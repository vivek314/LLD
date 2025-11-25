package behavorial.iterator;

public class SimplePlaylistIterator implements PlaylistIterator {
	private Playlist playlist;
	private int index;

	public SimplePlaylistIterator(Playlist playlist) {
		this.playlist = playlist;
	}
	@Override
	public boolean hasNext() {
		return index < playlist.getSongs().size();
	}

	@Override
	public String next() {
		return playlist.getSongs().get(index++);
	}
}
