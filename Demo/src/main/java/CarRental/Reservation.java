package CarRental;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Reservation {
	private final String reservationId;
	private final Customer customer;

	public Car getCar() {
		return car;
	}

	private final Car car;

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	private LocalDate startDate;

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	private LocalDate endDate;
	private final double totalPrice;

	public String getReservationId() {
		return reservationId;
	}

	public Reservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
		this.reservationId = UUID.randomUUID().toString();
		this.customer = customer;
		this.car = car;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = calculateTotalPrice();
	}
	double calculateTotalPrice() {
		double totalPrice = 0;
		double pricePerDay = car.getPrice();
		long days = ChronoUnit.DAYS.between(startDate, endDate);
		return (double) days*pricePerDay;
	}


}
