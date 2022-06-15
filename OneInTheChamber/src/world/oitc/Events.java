package world.oitc;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import world.oitc.gameplay.GameRoom;

public class Events implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		OITCPlayer oitcPlayer = new OITCPlayer(player);
		Main.getPlayerManager().addPlayer(oitcPlayer);
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		OITCPlayer oitcPlayer = Main.getPlayerManager().getPlayer(player);
		Main.getPlayerManager().removePlayer(oitcPlayer);

	}

	// This event will handle creation of gameroom signs
	@EventHandler
	public void onSignCreation(SignChangeEvent event) {
		Player player = event.getPlayer();

		// Only admins can create gameroom signs
		if (!player.hasPermission("oitc.admin"))
			return;

		// If they placed a blank sign, return
		if (event.getLine(0).isEmpty())
			return;

		String firstLine = event.getLine(0).toLowerCase();

		// Format to create a sign will be [room#<id>], with <id> being the roomId
		// number
		if (firstLine.startsWith("[room#") && firstLine.endsWith("]")) {
			// if they don't put in a number, return
			if (firstLine.equals("[room#]"))
				return;
			// need to parse the string to grab the number from the middle
			int i = firstLine.indexOf("#");
			int e = firstLine.indexOf("]");
			String idString = firstLine.substring(i + 1, e);

			// If they don't enter a valid number for the room ID, cancel the placement and
			// send error msg
			if (Integer.valueOf(idString) == null) {
				player.sendMessage(Main.messages.invalidRoomNumber());
				event.setCancelled(true);
				return;
			}

			int id = Integer.valueOf(idString);
			if (!Main.getGameRoomManager().getGameRooms().containsKey(id)) {
				player.sendMessage(Main.messages.invalidRoomNumber());
				event.setCancelled(true);
				return;
			}

			// At this point we know the number they entered was a valid GameRoom ID so we
			// need to
			// store the sign location in a file so that it can be loaded from now on at
			// startup.

			// If the gameroom already has a sign, we will cancel the event.
			if (Main.getGameRoomManager().getGameRoom(id).getSign() != null) {
				player.sendMessage(Main.messages.gameRoomAlreadyHasSign());
				event.setCancelled(true);
				return;
			}

			Location loc = event.getBlock().getLocation();
			Main.getGameRoomManager().addSign(id, loc);
			player.sendMessage(Main.messages.gameroomSignCreated());
		}
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		Material type = block.getType();

		if (type.equals(Material.SIGN) || type.equals(Material.WALL_SIGN)) {
			Sign sign = (Sign) block.getState();

			for (GameRoom room : Main.getGameRoomManager().getGameRooms().values()) {
				if (room.getSign() == null)
					return;
				if (room.getSign().getBlock().getLocation().equals(block.getLocation())) {
					Main.getGameRoomManager().deleteSign(room.getRoomId(), block.getLocation());
					player.sendMessage(Main.messages.gameRoomSignDeleted());
				}
			}
		}

	}

	// arrow hit player event
	// dont let players own arrow kill themself
	@EventHandler
	public void onArrowHit(ProjectileHitEvent event) {
		if (!event.getEntity().getType().equals(EntityType.ARROW))
			return;
		Arrow arrow = (Arrow) event.getEntity();

		if (!(arrow.getShooter() instanceof Player))
			return;
		Player player = (Player) arrow.getShooter();
		OITCPlayer oitcPlayer = Main.getPlayerManager().getPlayer(player);

		if (!oitcPlayer.isInGame())
			return;

	}

	// player hit player event
	@EventHandler
	public void onAttack(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		OITCPlayer oitcPlayer = Main.getPlayerManager().getPlayer(player);

		if (!oitcPlayer.isInGame())
			return;

	}

	// player death event
	// from arrow
	// from sword

}
