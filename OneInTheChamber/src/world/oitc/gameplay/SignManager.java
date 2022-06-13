package world.oitc.gameplay;

public class SignManager {
	/*
	 * SignManager will update the GameRoom's sign every second with player count,
	 * GameState status, and visual effects (>>> <<< , >> << , > <)
	 */

	private GameRoom _gameRoom;

	public SignManager(GameRoom gameRoom) {
		this._gameRoom = gameRoom;
	}

}
