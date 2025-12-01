package CarRental;

import java.time.LocalDate;

public class Car {
	String model;
	String year;
	String licenseNumber;
	double price;
	Boolean isOccupied;


	public Boolean getOccupied() {
		return isOccupied;
	}

	public void setOccupied(Boolean occupied) {
		isOccupied = occupied;
	}

	public String getModel() {
		return model;
	}

	public String getYear() {
		return year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Car(String model, String year, String licenseNumber, double price, Boolean isOccupied) {
		this.model = model;
		this.year = year;
		this.licenseNumber = licenseNumber;
		this.price = price;
		this.isOccupied = isOccupied;
	}

}
