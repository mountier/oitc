package world.oitc.gameplay;

import org.bukkit.plugin.Plugin;

import world.oitc.gameplay.managers.GamePlayerManager;
import world.oitc.gameplay.managers.MapManager;
import world.oitc.gameplay.managers.SignManager;
import world.oitc.gameplay.managers.GameTypeManager.GameType;

public class GameRoom {

	/*
	 * Game Room class will manage game states, players, worlds, spawns, etc.
	 * 
	 */

	private final Plugin _plugin;
	private final MapManager _mapManager;
	private final GamePlayerManager _playerManager;
	private final SignManager _signManager;
	private final int _roomId;

	public GameState _gameState = GameState.LOBBY;
	public boolean _ranked;
	public GameType _gameType;

	public GameRoom(Plugin plugin, int roomId, boolean isRanked, GameType type) {
		this._plugin = plugin;
		this._mapManager = new MapManager(this);
		this._playerManager = new GamePlayerManager(this);
		this._signManager = new SignManager(this);
		this._roomId = roomId;
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

	public GamePlayerManager getPlayerManager() {
		return this._playerManager;
	}

	public SignManager getSignManager() {
		return this._signManager;
	}

	public GameState getGameState() {
		return this._gameState;
	}

	public int getRoomId() {
		return this._roomId;
	}

	public boolean isRanked() {
		return _ranked;
	}

	public GameType getGameType() {
		return _gameType;
	}

}
