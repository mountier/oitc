package world.oitc.gameplay.managers;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import world.oitc.Main;
import world.oitc.gameplay.GameRoom;
import world.oitc.gameplay.gametypes.Duel;
import world.oitc.gameplay.gametypes.Standard;
import world.oitc.util.FileManager;

public class GameRoomManager {

	private HashMap<Integer, GameRoom> _gameRooms;
	private Plugin _plugin;
	private final String gameRoomsFileName = "gamerooms";

	public GameRoomManager(Plugin plugin) {
		_gameRooms = new HashMap<Integer, GameRoom>();
	
		GameRoom gameRoom1 = new GameRoom(_plugin, 1, false, new Duel());
		_gameRooms.put(1, gameRoom1);
		
		GameRoom gameRoom2 = new GameRoom(_plugin, 2, true, new Standard());
		_gameRooms.put(2, gameRoom2);
	}

	public void loadGameRoomsFromFile() {
		FileManager manager = Main.getFileManager();
		File file = manager.getFile(gameRoomsFileName);

		for (int id : getGameRooms().keySet()) {
			GameRoom room = getGameRooms().get(id);

			// If the gameroom doesn't have a sign synced, return.
			if (!manager.hasPath("gameroom" + id + ".sign", file))
				return;

			Location signLoc = Main.getWarpManager().readBasicLocation("gameroom" + id + ".sign", file);

			// If for some reason the location doesn't read correctly, return
			if (signLoc == null)
				return;

			room.setSign(signLoc);
		}
	}

	public void addSign(int id, Location loc) {
		FileManager manager = Main.getFileManager();
		File file = manager.getFile(gameRoomsFileName);
		String path = "gameroom" + id + ".sign";

		Main.getWarpManager().saveBasicLocation(path, file, loc);
		getGameRoom(id).setSign(loc);
	}

	public void deleteSign(int id, Location loc) {
		FileManager manager = Main.getFileManager();
		File file = manager.getFile(gameRoomsFileName);
		String path = "gameroom" + id + ".sign";

		manager.set(path, null, file);
		getGameRoom(id).setSign(null);
	}

	public HashMap<Integer, GameRoom> getGameRooms() {
		return _gameRooms;
	}

	public GameRoom getGameRoom(int id) {
		return _gameRooms.get(id);
	}

}
