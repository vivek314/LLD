package CarRental;

import CarRental.payment.PaymentProcesser;
import behavorial.strategy.PaymentProcessor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRentalSystem {
	private Map<String, Car> carMap;
	private Map<String, Reservation>  reservationMap;
	private PaymentProcesser paymentProcesser;
	public CarRentalSystem(PaymentProcesser paymentProcesser) {
		this.carMap = new HashMap();
		this.reservationMap = new HashMap<>();
		this.paymentProcesser = paymentProcesser;
	}
	public void addCar(Car car) {
		carMap.put(car.getLicenseNumber(), car);
	}

	public List<Car> getAvailableCars() {
		List<Car> availableCars = new ArrayList<>();
		for (Map.Entry<String, Car> entry : carMap.entrySet()) {
			if(!entry.getValue().isOccupied){
				availableCars.add(entry.getValue());
			}
		}
		return availableCars;
	}

	public Boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
		for(Reservation reservation : reservationMap.values()){
			if(reservation.getCar().equals(car)){
				if(startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())){
					return false;
				}
			}
		}
		return true;
	}

	public Reservation makeReservation(Car car, Customer customer, LocalDate startDate, LocalDate endDate) {
		Reservation reservation = null;
		if(isCarAvailable(car, startDate, endDate)){
			reservation = new Reservation(customer, car, startDate, endDate);
			car.isOccupied = true;
			reservationMap.put(reservation.getReservationId(), reservation);
		}
		return reservation;
	}

	public void modifyReservation(String reservationId, LocalDate startDate, LocalDate endDate){
		Car car = reservationMap.get(reservationId).getCar();
		Reservation reservation = reservationMap.get(reservationId);
		if(isCarAvailable(car, startDate, endDate)){
			reservation.setEndDate(endDate);
			reservation.setStartDate(startDate);
		}
	}

	public void removeReservation(String reservationId){
		Reservation reservation = reservationMap.remove(reservationId);
		if(reservation != null){
			reservation.getCar().isOccupied = false;
		}
	}

	public boolean makePayment(Reservation reservation) {

	}
}
