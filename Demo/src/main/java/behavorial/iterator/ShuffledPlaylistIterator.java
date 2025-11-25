package behavorial.iterator;

import java.util.ArrayList;
import java.util.Collections;

public class ShuffledPlaylistIterator implements PlaylistIterator {
	private Playlist playlist;
	private int index;
	private final ArrayList<String> shuffledSongs;

	public ShuffledPlaylistIterator(Playlist playlist) {
		this.playlist = playlist;
		this.index = 0;
		this.shuffledSongs = new ArrayList<>(playlist.getSongs());
		Collections.shuffle(shuffledSongs);
	}
	@Override
	public boolean hasNext() {
		return index < shuffledSongs.size();
	}

	@Override
	public String next() {
		return shuffledSongs.get(index++);
	}
}
