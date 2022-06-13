package world.oitc.gameplay;

public class MapManager {
	/*
	 * MapManager will manage all the maps for one single room. Each room will have
	 * its own world with a copy of every map. MapManager will also manage picking
	 * spawn locations during the game and providing Location objects for them.
	 */
	
	private GameRoom _gameRoom;

	public MapManager(GameRoom gameRoom) {
		this._gameRoom = gameRoom;
	}

}
