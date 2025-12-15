package movieBookingSystem;

import java.util.List;

public class Booking {
	private final int id;
	private final Show show;
	private final User user;
	private final List<Seat> seatList;
	private BookingStatus bookingStatus;

	public Booking(int id, Show show, User user, List<Seat> seatList) {
		this.id = id;
		this.show = show;
		this.user = user;
		this.seatList = seatList;
		this.bookingStatus = BookingStatus.CREATED;
	}

	public boolean isConfirmed(){
		return this.bookingStatus == BookingStatus.CONFIRMED;
	}

	public void confirmBooking() throws  Exception{
		if(this.bookingStatus!=BookingStatus.CREATED){
			throw new Exception("Cannot change booking status if it is not from created");
		}
		this.bookingStatus = BookingStatus.CONFIRMED;
	}

	public void expireBooking() throws Exception{
		if(this.bookingStatus!=BookingStatus.CREATED){
			throw new Exception("Cannot change booking status if it is not from created");
		}
		this.bookingStatus = BookingStatus.EXPIRED;
	}

	public int getId() {
		return this.id;
	}
	public Show getShow() {
		return this.show;
	}
	public User getUser() {
		return this.user;
	}
	public List<Seat> getSeatList() {
		return this.seatList;
	}
	public BookingStatus getBookingStatus() {
		return this.bookingStatus;
	}
}
