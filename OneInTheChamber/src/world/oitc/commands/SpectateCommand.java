package world.oitc.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import world.oitc.Main;

public class SpectateCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.messages.commandForPlayersOnly());
        }
        Player player =  (Player) sender;


        //If sender types /spectate, put player in spectator mode
        if (args.length < 1) {
            player.setGameMode(GameMode.SPECTATOR);
            return true;
        }
        //If sender types /spectate + user, and if user is valid, put sender in spectator mode and teleport them to the valid user
        if (args.length < 2) {
            player.setGameMode(GameMode.SPECTATOR);
            //Set location to user specified
        }
        return false;
    }
}
