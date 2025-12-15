package movieBookingSystem.payment;

public class DebitCardStrategy implements PaymentStrategy {
	public boolean pay() {
		return true;
	}
}
