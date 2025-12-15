package movieBookingSystem;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ShowService {
	private Map<Integer, Show> showMap;
	private AtomicInteger showCounter;

	public ShowService() {
		showCounter = new AtomicInteger(0);
		showMap = new HashMap<Integer, Show>();
	}

	public Show getShow(Integer showId) {
		if(showMap.containsKey(showId)) {
			return showMap.get(showId);
		}
		return null;
	}

	public void createShow(Movie movie, Screen screen, int durationInMinutes) {
		Date now = new Date();
		int newShowId = showCounter.incrementAndGet();
		showMap.put(newShowId, new Show(newShowId, movie, screen, now, durationInMinutes));
	}
}
