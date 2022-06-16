package world.oitc.gameplay.gametypes;

public class Elimination implements GameType {

	@Override
	public int getMaxPlayers() {
		return 12;
	}

	@Override
	public int getMinStartingPlayers() {
		return 3;
	}

	@Override
	public int getTimeLimitInMinutes() {
		return 20;
	}

	@Override
	public int getEarlyQuitTimeSeconds() {
		return 10;
	}

	@Override
	public int getAbandonMatchKillsLimit() {
		return 0;
	}

	@Override
	public String getSignName() {
		return "Elimination";
	}

}
