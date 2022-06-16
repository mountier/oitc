package world.oitc.gameplay;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Location;

public class OITCMap {

	private boolean _playable;
	private ArrayList<Location> _spawns;
	private ArrayList<String> _authors;
	private String _name;

	public OITCMap() {
		this._playable = false;
	}
	
	public void loadMap(File file, String name) {
		// if at least one spawn can be loaded, the map becomes playable
	}
	
	public boolean isPlayable() {
		return this._playable;
	}
	
	public ArrayList<Location> getSpawns() {
		return this._spawns;
	}
	
	public ArrayList<String> getAuthors() {
		return this._authors;
	}
	
	public String getName() {
		return this._name;
	}
	
}
