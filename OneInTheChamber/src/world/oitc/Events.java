package world.oitc;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
	
	// arrow hit player event
	// dont let players own arrow kill themself
	@EventHandler
	public void onArrowHit(ProjectileHitEvent event) {
		if(!event.getEntity().getType().equals(EntityType.ARROW))
			return;
		Arrow arrow = (Arrow) event.getEntity();
		
		if(!(arrow.getShooter() instanceof Player)) 
			return;
		Player player = (Player) arrow.getShooter();
		OITCPlayer oitcPlayer = Main.getPlayerManager().getPlayer(player);
	
		
	}
	
	// player hit player event
	@EventHandler
	public void onAttack(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		OITCPlayer oitcPlayer = Main.getPlayerManager().getPlayer(player);
		
		if(!oitcPlayer.isInGame()) 
			return;
		
		
	}
	
	// player death event 
	 	// from arrow
	 	// from sword
	

	
}
