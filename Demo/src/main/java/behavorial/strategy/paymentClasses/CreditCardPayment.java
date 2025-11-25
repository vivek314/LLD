package behavorial.strategy.paymentClasses;

import behavorial.strategy.PaymentMethod;

public class CreditCardPayment implements PaymentMethod {
	public void processPayment() {
		System.out.println("Credit Card Payment");
	}
}
