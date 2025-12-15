package movieBookingSystem.payment;

import movieBookingSystem.BookingService;
import movieBookingSystem.User;

public class PaymentService {
	private PaymentStrategy strategy;
	private BookingService bookingService;

	public PaymentService(PaymentStrategy strategy, BookingService bookingService) {
		this.strategy = strategy;
		this.bookingService = bookingService;
	}

	void processPayment(int bookingId, User user) throws Exception {
		if(strategy.pay()) {
			bookingService.confirmBooking(bookingService.getBooking(bookingId), user);
		} else{
			System.out.println("Payment failed, try again!");
		}
	}

}
