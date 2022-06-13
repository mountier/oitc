package world.oitc.gameplay;

import org.bukkit.plugin.Plugin;

import world.oitc.gameplay.GameTypeManager.GameType;

public class GameRoom {
	/*
	 * Game Room class will manage game states, players, worlds, spawns, etc.
	 * 
	 * TODO:
	 * Each Gameroom will have its own file with the location of any signs it's linked to, 
	 * the type of gamemode (duel, ranked, etc), any any other info that will be specific to gamerooms.
	 * 
	 * The signs should be loaded from the gamerooms file when the plugin is loaded and immediately start updating.
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

	public GameRoom(Plugin plugin, int roomId) {
		this._plugin = plugin;
		this._mapManager = new MapManager(this);
		this._playerManager = new GamePlayerManager(this);
		this._signManager = new SignManager(this);
		this._roomId = roomId;
		
		loadGameRoomFile();
	}
	
	public void loadGameRoomFile() {
		// THESE WILL BE LOADED IN FILE THE YML FILE
		// load game type
		// load sign location
		_ranked = false;
		_gameType = GameType.PUBLIC;
		// load if room is ranked or not
	}

	public void setGameState(GameState gameState) {
		// Don't switch state to current state (prevents double-starting)
		if(getGameState() == gameState) return;
		
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
