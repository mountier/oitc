package world.oitc.gameplay;

public class GameTypeManager {

	public enum GameType {
		DUEL, PUBLIC, ELIM, GUNFIGHT;
	}

	public static int getMaxPlayers(GameType type) {
		switch (type) {
		case DUEL:
			return 2;
		case PUBLIC:
			return 12;
		case ELIM:
			return 12;
		case GUNFIGHT:
			return 4;
		}
		return 0;
	}
	
	public static int getMinStartingPlayers(GameType type) {
		switch (type) {
		case DUEL:
			return 2;
		case PUBLIC:
			return 3;
		case ELIM:
			return 3;
		case GUNFIGHT:
			return 4;
		}
		return 0;
	}
	
	public static int getTimeLimitInMinutes(GameType type) {
		switch (type) {
		case DUEL:
			return 30;
		case PUBLIC:
			return 20;
		case ELIM:
			return 10;
		case GUNFIGHT:
			return 20;
		}
		return 0;
	}

	public static int getEarlyQuitTimeSeconds(GameType type) {
		switch (type) {
		case DUEL:
			return 5;
		case PUBLIC:
			return 20;
		case ELIM:
			return 20;
		case GUNFIGHT:
			return 10;
		}
		return 0;
	}
	
	public static int getAbandonMatchKillsLimit(GameType type) {
		switch (type) {
		case DUEL:
			return 0;
		case PUBLIC:
			return 5;
		case ELIM:
			return 0;
		case GUNFIGHT:
			return 0;
		}
		return 0;
	}

	
}
