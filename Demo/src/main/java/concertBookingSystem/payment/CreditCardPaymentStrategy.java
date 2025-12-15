package concertBookingSystem.payment;

public class CreditCardPaymentStrategy implements PaymentStrategy {
	public void pay(int total) {
		System.out.println(total + "Rs. " + "Payment made through credit card");
	}
}
