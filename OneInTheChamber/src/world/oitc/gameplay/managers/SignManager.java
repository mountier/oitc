package world.oitc.gameplay.managers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.plugin.Plugin;

import world.oitc.Main;
import world.oitc.gameplay.GameRoom;

public class SignManager {

	/*
	 * SignManager will update the GameRoom's sign every second with player count,
	 * GameState status, and visual effects (>>> <<< , >> << , > <)
	 */

	private Plugin _plugin;

	public SignManager(Plugin plugin) {
		this._plugin = plugin;
	}

	public void updateSign(GameRoom room) {
		Location signLoc = room.getSign();
		Sign sign = (Sign) signLoc.getBlock().getState();

		String line0 = sign.getLine(0);
		String line1 = sign.getLine(1);
		String line2 = sign.getLine(2);
		String line3 = sign.getLine(3);

		sign.setLine(0, "");
		sign.setLine(1, "");
		sign.setLine(2, getAnimationLine(line2));
		sign.setLine(3, "");

		sign.update(true);
	}

	public String getAnimationLine(String currentLine) {
		switch (currentLine) {
		case ">>> <<<":
			return ">> <<";
		case ">> <<":
			return "> <";
		case "> <":
			return " ";
		case " ":
			return ">>> <<<";
		}
		return ">>> <<<";
	}

	// This will run every third of a second, and update any signs that it has to.
	public void startSignAnimations() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(_plugin, new Runnable() {
			public void run() {
				for (GameRoom room : Main.getGameRoomManager().getGameRooms().values()) {
					// Don't update sign if the room doesn't have a sign yet
					if (room.getSign() != null)
						updateSign(room);
				}
			}
		}, 0, (20L / 3L));
	}

}
