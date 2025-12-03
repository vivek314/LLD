package LibraryManagementSystem.payment;

public class DebitCardPayment implements PaymentStrategy {
	@Override
	public void pay(double amount) {
		System.out.println("DebitCardPayment: "+amount);
	}
}
