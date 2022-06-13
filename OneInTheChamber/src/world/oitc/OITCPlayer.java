package world.oitc;

import org.bukkit.entity.Player;

public class OITCPlayer {
	/*
	 * OITCPlayer will be an efficient way to store and manage player data as well
	 * as manipulate the Player object while the player is online. OITCPlayer object
	 * will allow us to check if a player is currently in a game, what game they're
	 * in, etc, without already having the GameRoom object available.
	 */

	private Player _player;
	private boolean _inGame;

	public OITCPlayer(Player player) {
		this._player = player;
		this._inGame = false;
	}


	public Player getPlayer() {
		return _player;
	}
	
	public boolean isInGame() {
		return _inGame;
	}

	public void setInGame(boolean inGame) {
		this._inGame = inGame;
	}
	

	// DATABASE STAT METHODS
	public void addStatKills() {
		
	}
	public void addStatSwordKills() {
		
	}
	public void addStatBowKills() {
		
	}
	public void addStatFistKills() {
		
	}
	public void addStatDeaths() {
		
	}
	public void addStatGamesPlayed() {
		
	}
	public void addStatGamesWon() {
		
	}
	public void addStatGamesLost() {
		
	}
	public void addStatArrowsShot() {
		
	}
	public void addStatArrowsMissed() {
		
	}
	public void addStatArrowsHit() {
		
	}
	public void addStatArrowsHitHeadshot() {
		
	}
	public void addStatAssists() {
		
	}

	
}

