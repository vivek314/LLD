package interview.ParkingLot.payment;

public class StripePaymentAdapter implements PaymentGatewayAdapter {
    @Override
    public boolean pay(double amount) {
        System.out.println("Stripe payment");
        return true;
    }
}
