package behavorial.iterator;

public class Main {
	public static void main(String[] args) {

		Playlist powerSongs =new Playlist();
		powerSongs.addSong("Power Song 1");
		powerSongs.addSong("Power Song 2");
		powerSongs.addSong("Power Song 3");

		PlaylistIterator iterator = powerSongs.getIterator("simple");

		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

		PlaylistIterator shuffledIterator = powerSongs.getIterator("shuffle");
		while(shuffledIterator.hasNext()){
			System.out.println(shuffledIterator.next());
		}
	}
}
