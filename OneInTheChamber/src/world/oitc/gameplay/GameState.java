package world.oitc.gameplay;

public enum GameState {
	/*
	 * GameState will include all stages of an OITC room.
	 * 
	 * LOBBY: Lobby is the default state of the game. A room will stay in lobby
	 * state until the required amount of players to start the game join the room.
	 * 
	 * PREGAME: Pregame state will start as soon as the room hits the required
	 * number of players to start the game.
	 * 
	 * STARTING: Starting state will begin when the game is full or a map is voted
	 * on by the majority. During starting the countdown will begin and players will
	 * be teleported to the voted upon map.
	 * 
	 * ACTIVE: Active state is the main portion of the game, and will include all
	 * gameplay.
	 * 
	 * ENDGAME: Endgame state will occur as soon as one player hits 20 kills. ELO
	 * will be calculated, PvP will be turned off, and after a short countdown
	 * players will be teleported out.
	 * 
	 * CLEANUP: Cleanup state will occur directly after Endgame. Cleanup state will
	 * run any methods necessary in order for the room to return back to lobby
	 * state.
	 * 
	 */

	LOBBY, PREGAME, STARTING, ACTIVE, ENDGAME, CLEANUP;

}
