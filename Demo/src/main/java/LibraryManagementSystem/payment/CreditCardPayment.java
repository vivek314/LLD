package LibraryManagementSystem.payment;

public class CreditCardPayment implements PaymentStrategy {
	@Override
	public void pay(double amount) {
		System.out.println("PAYMENT with credit card: "+ amount);
	}
}
