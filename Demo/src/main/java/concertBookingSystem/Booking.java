package concertBookingSystem;

import java.util.List;
import java.util.UUID;

public class Booking {
	private String userId;
	private String concertId;
	private final String ticketId;
	private final List<Seat> seats;
	private final int price;

	public Booking(String userId, String concertId, List<Seat> seats) {
		this.userId = userId;
		this.concertId = concertId;
		this.ticketId = UUID.randomUUID().toString();
		this.seats = seats;
		this.price = getTotalPrice();
	}

	private int getTotalPrice() {
		int total = 0;
		for (Seat seat : seats) {
			total+=seat.getCost();
		}
		return total;
	}
}
