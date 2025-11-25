package behavorial.strategy.paymentClasses;

import behavorial.strategy.PaymentMethod;

public class DebitCardPayment implements PaymentMethod {
	public void processPayment() {
		System.out.println("Debit Card Payment");
	}
}
