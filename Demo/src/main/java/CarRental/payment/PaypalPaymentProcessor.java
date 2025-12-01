package CarRental.payment;

import behavorial.strategy.PaymentProcessor;

public class PaypalPaymentProcessor implements PaymentProcesser {

	@Override
	public boolean processPayment(double amount) {
		System.out.println("PayPal Payment and paid: "+ amount);
		return true;
	}
}
