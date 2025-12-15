package concertBookingSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Concert {
	private final String id;
	private final String artist;
	private String venue;
	private LocalDate date;
	private LocalDateTime time;
	private int capacity;

	public Concert(String artist, String venue, LocalDate date, LocalDateTime time, int capacity) {
		this.id = UUID.randomUUID().toString();
		this.artist = artist;
		this.venue = venue;
		this.date = date;
		this.time = time;
		this.capacity = capacity;
	}

	public String getId() {
		return id;
	}

	public String getArtist() {
		return artist;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
