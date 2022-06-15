package world.oitc.gameplay;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import world.oitc.gameplay.managers.GameTypeManager.GameType;
import world.oitc.gameplay.managers.MapManager;

public class GameRoom {

	/*
	 * Game Room class will manage game states, players, worlds, spawns, etc.
	 * 
	 */

	private final Plugin _plugin;
	private final MapManager _mapManager;
	private final int _roomId;

	public GameType _gameType;
	public GameState _gameState;
	public boolean _ranked;
	public Location _sign;

	// We don't want to make an arraylist with the actual OITCPlayer object so
	// instead we'll store their UUID and use the HashMap provided by PlayerManager
	// to get the OITCPlayer object.
	public ArrayList<UUID> players;

	public GameRoom(Plugin plugin, int roomId, boolean isRanked, GameType type) {
		this._plugin = plugin;
		this._mapManager = new MapManager(this);
		this._roomId = roomId;

		this._gameType = type;
		this._gameState = GameState.LOBBY;
		this._ranked = isRanked;
	}

	public void setGameState(GameState gameState) {
		// Don't switch state to current state (prevents double-starting)
		if (getGameState() == gameState)
			return;

		this._gameState = gameState;
		switch (gameState) {
		case LOBBY:
			// lobby
			break;
		case PREGAME:
			// pregame
			break;
		case STARTING:
			// starting
			break;
		case ACTIVE:
			// active
			break;
		case ENDGAME:
			// endgame
			break;
		case CLEANUP:
			// cleanup
			break;
		}
	}

	public void cleanup() {

	}

	public Plugin getPlugin() {
		return this._plugin;
	}

	public MapManager getMapManager() {
		return this._mapManager;
	}

	public GameState getGameState() {
		return this._gameState;
	}

	public int getRoomId() {
		return this._roomId;
	}

	public boolean isRanked() {
		return this._ranked;
	}

	public GameType getGameType() {
		return null;
	}

	public Location getSign() {
		return this._sign;
	}

	public void setSign(Location location) {
		this._sign = location;
	}

}
