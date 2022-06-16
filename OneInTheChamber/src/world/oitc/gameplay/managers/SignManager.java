package world.oitc.gameplay.managers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;
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

		String line2 = sign.getLine(2);
		String rankedLine = ChatColor.RED + "Unranked";

		if (room.isRanked())
			rankedLine = ChatColor.GREEN + "Ranked";

		sign.setLine(0, ChatColor.BOLD + "[" + room.getGameType().getSignName() + "]");
		sign.setLine(1, rankedLine);
		sign.setLine(2, ChatColor.DARK_BLUE + "" + ChatColor.BOLD + getAnimationLine(line2));
		sign.setLine(3, room.getPlayers().size() + "/" + room.getGameType().getMaxPlayers());

		sign.update(true);
	}

	public String getAnimationLine(String currentLine) {
		switch (ChatColor.stripColor(currentLine)) {
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
