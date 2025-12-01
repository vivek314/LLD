package CarRental.payment;

import behavorial.strategy.PaymentProcessor;

public class CreditCardPaymentProcessor implements PaymentProcesser {

	@Override
	public boolean processPayment(double amount) {
		System.out.println("Credit Card Payment and paid: "+ amount);
		return true;
	}
}
