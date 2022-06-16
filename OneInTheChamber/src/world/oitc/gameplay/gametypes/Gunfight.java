package world.oitc.gameplay.gametypes;

public class Gunfight implements GameType {

	@Override
	public int getMaxPlayers() {
		return 4;
	}

	@Override
	public int getMinStartingPlayers() {
		return 4;
	}

	@Override
	public int getTimeLimitInMinutes() {
		return 20;
	}

	@Override
	public int getEarlyQuitTimeSeconds() {
		return 20;
	}

	@Override
	public int getAbandonMatchKillsLimit() {
		return 0;
	}

	@Override
	public String getSignName() {
		return "Gunfight";
	}

}
