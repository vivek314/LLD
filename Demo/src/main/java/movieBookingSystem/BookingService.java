package movieBookingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingService {
	private SeatLockProvider seatLockProvider;
	private Map<Integer, Booking> bookingMap;
	private AtomicInteger bookingId;
	public BookingService(){
		this.bookingMap = new ConcurrentHashMap<>();
		bookingId = new AtomicInteger(0);
	}

	public Booking createBooking(Show show, User user, List<Seat> seatList) throws Exception{
		if(isAnySeatAlreadyBooked(show, seatList)){
			throw new Exception("Some seats are already booked");
		}
		seatLockProvider.lockSeats(show, seatList, user);
		int newBookingId = bookingId.incrementAndGet();
		Booking booking = new Booking(newBookingId, show, user, seatList);
		bookingMap.put(newBookingId, booking);
		return booking;
	}

	public void confirmBooking(Booking booking, User user) throws Exception{
		if(!booking.getUser().equals(user)){
			throw new Exception("Cannot confirm booking made by another user");
		}
		for(Seat seat: booking.getSeatList()){
			if(!seatLockProvider.validateLock(booking.getShow(), seat, user)){
				throw new Exception("Acquired lock is either invalid or has expired");
			};
		}
		booking.confirmBooking();
	}

	public List<Seat> getBookedSeats(Show show){
		List<Seat> seatLists = new ArrayList<>();
		for(Booking booking : bookingMap.values()){
			if(booking.isConfirmed()){
				seatLists.addAll(booking.getSeatList());
			}
		}
		return seatLists;
	}

	private boolean isAnySeatAlreadyBooked(Show show, List<Seat> seatList) {
		List<Booking> bookings = getAllBookings(show);
		for(Booking booking: bookings){
			List<Seat> bookedSeats = booking.getSeatList();
			boolean hasCommon = bookedSeats.stream().anyMatch(seatList::contains);
			if(hasCommon) return true;
		}
		return false;
	}

	public Booking getBooking(int bookingId) throws Exception{
		if(bookingMap.containsKey(bookingId)){
			return bookingMap.get(bookingId);
		}
		throw new Exception("No booking found");
	}

	public List<Booking> getAllBookings(Show show){
		List<Booking> response = new ArrayList<>();
		for(Booking booking : bookingMap.values()){
			if(booking.getShow().equals(show)) response.add(booking);
		}
		return response;
	}

}
