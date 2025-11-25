package behavorial.strategy.paymentClasses;

import behavorial.strategy.PaymentMethod;

public class StripePayment implements PaymentMethod {
	public void processPayment() {
		System.out.println("Stripe Payment");
	}
}
