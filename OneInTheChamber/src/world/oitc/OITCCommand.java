package world.oitc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OITCCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(Main.messages.commandForPlayersOnly());
			return true;
		}
		Player player = (Player) sender;
		OITCPlayer oitcPlayer = Main.getPlayerManager().getPlayer(player);
		
		if(args.length < 1) {
			// /oitc 
			player.sendMessage(Main.messages.notEnoughArguments());
			return true;
		}
		
		//          args[0]  args[1] args[2] args[3]  args[4]
		// /message Mountier hi       how    are      you
		
		// /oitc <subCommand> 
		String subCommand = args[0];
		
		
		return false;
	}

}
