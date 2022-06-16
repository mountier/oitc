package world.oitc.gameplay.gametypes;

public class Duel implements GameType {

	@Override
	public int getMaxPlayers() {
		return 2;
	}

	@Override
	public int getMinStartingPlayers() {
		return 2;
	}

	@Override
	public int getTimeLimitInMinutes() {
		return 30;
	}

	@Override
	public int getEarlyQuitTimeSeconds() {
		return 5;
	}

	@Override
	public int getAbandonMatchKillsLimit() {
		return 0;
	}

	@Override
	public String getSignName() {
		return "Duel";
	}

}
