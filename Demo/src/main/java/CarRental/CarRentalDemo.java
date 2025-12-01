package CarRental;

import CarRental.payment.CreditCardPaymentProcessor;
import CarRental.payment.PaymentProcesser;

import java.time.LocalDate;
import java.util.List;

public class CarRentalDemo {
	public static void main(String[] args) {
		PaymentProcesser paymentProcesser = new CreditCardPaymentProcessor();
		CarRentalSystem carRentalSystem = new CarRentalSystem(paymentProcesser);
		carRentalSystem.addCar(new Car("Tata", "2002", "AP34LS1234", 10.0, false));
		carRentalSystem.addCar(new Car("Hyundai", "2003", "TS12YU8976", 11.0, false));

		Customer customer = new Customer("Vivek", "921039842034", "IU098");

		List<Car> availableCars = carRentalSystem.getAvailableCars();
		if(availableCars!=null) {
			Car selectedCar = availableCars.get(0);
			Reservation reservation = carRentalSystem.makeReservation(selectedCar, customer, LocalDate.of(2025, 2, 2), LocalDate.of(2025, 2, 6));
			if(reservation!=null) {
				boolean paymentStatus = carRentalSystem.makePayment(reservation);
				if(paymentStatus) {
					System.out.println("Payment Successful and car rented for the available time line");
				}
				else{
					System.out.println("Payment Unsuccessful and car not rented for the available time line");
					carRentalSystem.removeReservation(reservation.getReservationId());
				}
			} else {
				System.out.println("Car not available for the given time line");
			}
		}else{
			System.out.println("No available cars for the given criteria");
		}

	}
}
