package movieBookingSystem;

import javax.print.DocFlavor;
import java.util.Date;

public class Show {
	private final int id;
	private final Movie movie;
	private final Screen screen;
	private final Date startTime;
	private final Integer durationInMinutes;

	public Show(int id, Movie movie, Screen screen, Date startTime, Integer durationInMinutes) {
		this.id = id;
		this.movie = movie;
		this.screen = screen;
		this.startTime = startTime;
		this.durationInMinutes = durationInMinutes;
	}

	public int getId() {
		return this.id;
	}
	public Movie getMovie() {
		return this.movie;
	}
	public Screen getScreen() {
		return this.screen;
	}
	public Date getStartTime() {
		return this.startTime;
	}
	public Integer getDurationInMinutes() {
		return this.durationInMinutes;
	}
}
