package world.oitc.gameplay.gametypes;

public interface GameType {

	 void getMaxPlayers();
	 void getMinStartingPlayers();
	 void getTimeLimitInMinutes();
	 void getEarlyQuitTimeSeconds();
	 void getAbandonMatchKillsLimit();
	 
}
