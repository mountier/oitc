package world.oitc.gameplay.managers;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import world.oitc.Main;
import world.oitc.gameplay.GameRoom;
import world.oitc.gameplay.managers.GameTypeManager.GameType;
import world.oitc.util.FileManager;

public class GameRoomManager {

	private HashMap<Integer, GameRoom> _gameRooms;
	private Plugin _plugin;
	private final String gameRoomsFileName = "gamerooms";
	
	public GameRoomManager(Plugin plugin) {
		_gameRooms = new HashMap<Integer, GameRoom>();
		GameRoom gameRoom1 = new GameRoom(_plugin, 1, false, GameType.DUEL);
		_gameRooms.put(1, gameRoom1);
	}
	
	public void loadGameRoomsFromFile() {
		FileManager manager = Main.getFileManager();
		File file = manager.getFile(gameRoomsFileName);
		
		for(int id : getGameRooms().keySet()) {
			GameRoom room = getGameRooms().get(id);
				
			if(!manager.hasPath("gamerooms" + id + ".signs", file))
				return;
			
			// check how many values of "signs" there are
			// load each sign individually
		}
	}
	
	public void addSign(int id, Location loc) {
	
	}
	
	public HashMap<Integer, GameRoom> getGameRooms() {
		return _gameRooms;
	}
	
}
