package concertBookingSystem.payment;

public class DebitCardPaymentStrategy implements PaymentStrategy {
	public void pay(int total) {
		System.out.println(total + "Rs. " + "Payment made through credit card");
	}
}
