package world.oitc.gameplay.tasks;

import org.bukkit.scheduler.BukkitRunnable;

import world.oitc.gameplay.GameRoom;
import world.oitc.gameplay.GameState;

public class GameStartCountdownTask extends BukkitRunnable {

	private GameRoom _gameRoom;
	
	public GameStartCountdownTask(GameRoom gameRoom) {
		this._gameRoom = gameRoom;
	}
	
	private int _timeLeft = 10;
	
	@Override
	public void run() {
		_timeLeft--;
		if(_timeLeft <= 0) {
			cancel();
			_gameRoom.setGameState(GameState.ACTIVE);
			return;
		}
		
		//broadcast countdown to players only in that game
	}
	
}
