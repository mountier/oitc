package world.oitc;

import org.bukkit.plugin.java.JavaPlugin;

import world.oitc.commands.OITCCommand;
import world.oitc.commands.SpectateCommand;
import world.oitc.gameplay.GameRoom;
import world.oitc.gameplay.managers.GameRoomManager;
import world.oitc.gameplay.managers.MapManager;
import world.oitc.gameplay.managers.SignManager;
import world.oitc.util.FileManager;
import world.oitc.util.PlayerManager;
import world.oitc.util.WarpManager;

public class Main extends JavaPlugin {


	private static GameRoomManager gameRoomManager;
	private static SignManager signManager;
	private static MapManager mapManager;
	private static PlayerManager playerManager;
	private static FileManager fileManager;
	private static WarpManager warpManager;
	public static Messages messages;

	@Override
	public void onEnable() {
		gameRoomManager = new GameRoomManager(this);
		signManager = new SignManager(this);
		mapManager = new MapManager();
		fileManager = new FileManager(this);
		playerManager = new PlayerManager();
		warpManager = new WarpManager();
		playerManager.createAllOnlinePlayers();
		messages = new Messages();

		this.getServer().getPluginManager().registerEvents(new Events(), this);
		this.getCommand("oitc").setExecutor(new OITCCommand());
		this.getCommand("spectate").setExecutor(new SpectateCommand());
		
		gameRoomManager.loadGameRoomsFromFile();
		signManager.startSignAnimations();
		mapManager.loadWorlds();
	}

	@Override
	public void onDisable() {
		// cleanup all game room (whatever the hell that means)
		for(GameRoom room : getGameRoomManager().getGameRooms().values())
			room.cleanup();
	}

	public static FileManager getFileManager() {
		return fileManager;
	}

	public static PlayerManager getPlayerManager() {
		return playerManager;
	}

	public static MapManager getMapManager() {
		return mapManager;
	}
	
	public static GameRoomManager getGameRoomManager() {
		return gameRoomManager;
	}

	public static WarpManager getWarpManager() {
		return warpManager;
	}
	
}
