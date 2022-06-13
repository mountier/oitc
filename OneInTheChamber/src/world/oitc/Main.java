package world.oitc;

import org.bukkit.plugin.java.JavaPlugin;

import world.oitc.gameplay.GameRoom;
import world.oitc.util.FileManager;
import world.oitc.util.PlayerManager;

public class Main extends JavaPlugin {
	
	/* FILE STRUCTURE: 
	 * plugins/oitc/gamerooms/1.yml
	 * plugins/oitc/gamerooms/2.yml .. .etc
	 * plugins/oitc/config.yml 
	 * plugins/oitc/maps <-- this will be a world folder with the maps
	 * plugins/oitc/mapConfig.yml <-- will hold spawn locations, name of maps, etc.
	 * 
	 * */
	
	/*
	 * COMMANDS
	 * 
	 * OITC 
	 * 
	 * OITCA 
	 * 
	 * join /join <roomId>
	 * leave /leave
	 * spectate /spectate <room>/<player>
	 * votestart /votestart
	 * stats /stats <player> <duel/ranked/gunfight>
	 * 
	 *  */

	// will eventually need 12-15 of these
	private static GameRoom gameRoom1;
	private static PlayerManager playerManager;
	private static FileManager fileManager;
	public static Messages messages;

	@Override
	public void onEnable() {
		gameRoom1 = new GameRoom(this, 1);
		fileManager = new FileManager(this);
		playerManager = new PlayerManager();
		playerManager.createAllOnlinePlayers();
		messages = new Messages();

		this.getServer().getPluginManager().registerEvents(new Events(), this);
		this.getCommand("oitca").setExecutor(new OITCCommand());
		
		// load all of the game rooms
	}

	@Override
	public void onDisable() {
		// cleanup all game room (whatever the hell that means)
		gameRoom1.cleanup();
	}

	public static FileManager getFileManager() {
		return fileManager;
	}

	public static PlayerManager getPlayerManager() {
		return playerManager;
	}

}
