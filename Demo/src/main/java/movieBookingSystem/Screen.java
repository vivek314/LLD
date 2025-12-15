package movieBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class Screen {
	private final int id;
	private final String name;
	private List<Seat> seats;
	private final Theatre theatre;

	public Screen(int id, String name, Theatre theatre) {
		this.id = id;
		this.name = name;
		this.seats = new ArrayList<Seat>();
		this.theatre = theatre;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public Theatre getTheatre() {
		return theatre;
	}

	public void addSeat(Seat seat) {
		seats.add(seat);
	}

}
