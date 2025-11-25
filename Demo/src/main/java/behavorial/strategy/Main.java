package behavorial.strategy;

import behavorial.strategy.paymentClasses.CreditCardPayment;
import behavorial.strategy.paymentClasses.DebitCardPayment;

public class Main {
	public static void main(String[] args) {
		PaymentMethod paymentMethod = new CreditCardPayment();
		PaymentProcessor paymentProcessor = new PaymentProcessor(paymentMethod);
		paymentProcessor.processPayment();
		paymentProcessor.setPaymentMethod(new DebitCardPayment());
		paymentProcessor.processPayment();
	}
}
