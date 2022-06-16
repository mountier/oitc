package world.oitc.gameplay.gametypes;

public interface GameType {

	 int getMaxPlayers();
	 int getMinStartingPlayers();
	 int getTimeLimitInMinutes();
	 int getEarlyQuitTimeSeconds();
	 int getAbandonMatchKillsLimit();
	 String getSignName();
	 
}
