package world.oitc;

import org.bukkit.ChatColor;

public class Messages {

	public String prefix = ChatColor.GOLD + "" + ChatColor.BOLD + "OITC " + ChatColor.YELLOW;

	public String format(String string) {
		return prefix + string;
	}

	public String commandForPlayersOnly() {
		return format("This command is for players only.");
	}

	public String notEnoughArguments() {
		return format("Not enough arguments!");
	}

	public String invalidRoomNumber() {
		return format("Invalid room number entered!");
	}

	public String gameroomSignCreated() {
		return format("Gameroom sign created.");
	}

	public String gameRoomAlreadyHasSign() {
		return format("That gameroom already has a sign, please break it first to sync a new sign.");
	}

	public String gameRoomSignDeleted() {
		return format("Gameroom sign succesfully deleted.");
	}

}
