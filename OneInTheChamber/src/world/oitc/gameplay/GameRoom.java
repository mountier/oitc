package world.oitc.gameplay;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import world.oitc.gameplay.gametypes.GameType;

public class GameRoom {

	/*
	 * Game Room class will manage game states, players, worlds, spawns, etc.
	 * 
	 */

	private final Plugin _plugin;
	private final int _roomId;

	public GameType _gameType;
	public GameState _gameState;
	public boolean _ranked;
	public Location _sign;

	// We don't want to make an arraylist with the actual OITCPlayer object so
	// instead we'll store their UUID and use the HashMap provided by PlayerManager
	// to get the OITCPlayer object.
	public ArrayList<UUID> _players;

	public GameRoom(Plugin plugin, int roomId, boolean isRanked, GameType type) {
		this._plugin = plugin;
		this._roomId = roomId;

		this._gameType = type;
		this._gameState = GameState.LOBBY;
		this._ranked = isRanked;

		this._players = new ArrayList<UUID>();
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

	public void addPlayer(UUID id) {
		this._players.add(id);
	}

	public void removePlayer(UUID id) {
		this._players.remove(id);
	}

	public Plugin getPlugin() {
		return this._plugin;
	}

	public GameState getGameState() {
		return this._gameState;
	}

	public List<UUID> getPlayers() {
		return this._players;
	}

	public int getRoomId() {
		return this._roomId;
	}

	public boolean isRanked() {
		return this._ranked;
	}

	public GameType getGameType() {
		return this._gameType;
	}

	public Location getSign() {
		return this._sign;
	}

	public void setSign(Location location) {
		this._sign = location;
	}

}
