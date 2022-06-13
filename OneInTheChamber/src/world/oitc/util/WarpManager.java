package world.oitc.util;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import world.oitc.Main;

public class WarpManager {
	/*
	 * Need to update this class with saveSpecificLocation and
	 * loadSpecificLocation methods that will also save pitch and yaw in order for
	 * players to face a specific direction when teleported
	 */

	public void saveLocation(String path, File file, Location location) {
		int x, y, z;
		String world;

		x = location.getBlockX();
		y = location.getBlockY();
		z = location.getBlockZ();
		world = location.getWorld().getName();

		Main.getFileManager().set(path + ".x", x, file);
		Main.getFileManager().set(path + ".y", y, file);
		Main.getFileManager().set(path + ".z", z, file);
		Main.getFileManager().set(path + ".world", world, file);
	}

	public Location readLocation(String path, File file) {
		int x, y, z;
		String world;

		x = (int) Main.getFileManager().get(path + ".x", file);
		y = (int) Main.getFileManager().get(path + ".y", file);
		z = (int) Main.getFileManager().get(path + ".z", file);
		world = Main.getFileManager().getString(path + ".world", file);

		try {
			return new Location(Bukkit.getWorld(world), x + 0.5, y + 0.5, z + 0.5, 0.0F, 0.0F);
		} catch (Exception e) {
			return null;
		}
	}

}
