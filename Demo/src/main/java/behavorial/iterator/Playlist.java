package behavorial.iterator;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
	List<String> songs;

	public Playlist() {
		this.songs = new ArrayList<String>();
	}
	public void addSong(String song) {
		this.songs.add(song);
	}
	public void removeSong(String song) {
		this.songs.remove(song);
	}
	public List<String> getSongs() {
		return songs;
	}
	public PlaylistIterator getIterator(String type) {
		return switch (type) {
			case "shuffle" -> new ShuffledPlaylistIterator(this);
			case "simple" -> new SimplePlaylistIterator(this);
			default -> null;
		};
	}
}
