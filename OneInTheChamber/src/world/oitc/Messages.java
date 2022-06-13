package world.oitc;

import org.bukkit.ChatColor;

public class Messages {

	public  String prefix = ChatColor.GOLD + "[OITC] " + ChatColor.GRAY;
	
	public String format(String string) {
		return prefix + string;
	}
	
	public String commandForPlayersOnly() {
		return format("This command is for players only.");
	}
	
	public String notEnoughArguments() {
		return format("Not enough arguments!");
	}
	
}
