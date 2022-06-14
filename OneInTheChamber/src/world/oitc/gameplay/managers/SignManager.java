package world.oitc.gameplay.managers;

import world.oitc.gameplay.GameRoom;

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
