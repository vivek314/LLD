package creational.FactoryPattern;

public class VehicleFactory {
	public static Vehicle getVehicle(String type){
		return switch (type) {
			case "Car" -> new Car();
			case "Truck" -> new Truck();
			case "Bike" -> new Bike();
			default -> throw new IllegalArgumentException("Invalid Vehicle type");
		};
	}
}
