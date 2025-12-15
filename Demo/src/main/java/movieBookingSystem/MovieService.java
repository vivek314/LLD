package movieBookingSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MovieService {
	private Map<Integer, Movie> movies;
	private AtomicInteger movieId;

	public MovieService() {
		movies = new HashMap<>();
		movieId = new AtomicInteger(0);
	}

	public Movie getMovie(int movieId) throws Exception {
		if(movies.containsKey(movieId)){
			return movies.get(movieId);
		} else{
			throw new Exception("Movie not found with given movieId: " + movieId);
		}
	}

	public void createMovie(String movieName, int durationInMinutes) {
		int newMovieId = movieId.incrementAndGet();
		movies.put(newMovieId, new Movie(newMovieId, movieName, durationInMinutes));
	}
}
