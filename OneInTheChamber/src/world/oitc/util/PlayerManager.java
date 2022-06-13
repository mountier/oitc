package world.oitc.util;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import world.oitc.OITCPlayer;

public class PlayerManager {

	private HashMap<UUID, OITCPlayer> players;

	public PlayerManager() {
		players = new HashMap<UUID, OITCPlayer>();
	}

	public void createAllOnlinePlayers() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			OITCPlayer oitcPlayer = new OITCPlayer(player);
			players.put(player.getUniqueId(), oitcPlayer);
		}
	}

	public OITCPlayer getPlayer(Player player) {
		return getPlayer(player.getUniqueId());
	}

	public OITCPlayer getPlayer(UUID id) {
		if (players.containsKey(id))
			return players.get(id);
		else
			return null;
	}

	public void addPlayer(OITCPlayer oitcPlayer) {
		players.put(oitcPlayer.getPlayer().getUniqueId(), oitcPlayer);
	}

	public void removePlayer(OITCPlayer oitcPlayer) {
		players.remove(oitcPlayer.getPlayer().getUniqueId());
	}

}
