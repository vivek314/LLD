package behavorial.strategy;

public class PaymentProcessor {
	private PaymentMethod paymentMethod;
	public PaymentProcessor(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public void processPayment() {
		paymentMethod.processPayment();
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}
