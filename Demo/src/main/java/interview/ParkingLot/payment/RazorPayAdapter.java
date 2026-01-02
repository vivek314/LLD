package interview.ParkingLot.payment;

public class RazorPayAdapter implements PaymentGatewayAdapter {
    @Override
    public boolean pay(double amount) {
        System.out.println("Razor pay adapter");
        return true;
    }

}
