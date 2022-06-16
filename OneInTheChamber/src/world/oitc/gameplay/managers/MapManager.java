package world.oitc.gameplay.managers;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

import world.oitc.Main;
import world.oitc.gameplay.GameRoom;

public class MapManager {

	public MapManager() {

	}

	public void loadMapData() {

	}

	// There needs to be a world for each GameRoom. Each world will include every
	// map.
	public void loadWorlds() {
		for (GameRoom rooms : Main.getGameRoomManager().getGameRooms().values()) {
			String worldName = "gameroom" + rooms.getRoomId();
			if (Bukkit.getWorld(worldName) == null)
				Bukkit.createWorld(new WorldCreator(worldName));
		}
	}

}
