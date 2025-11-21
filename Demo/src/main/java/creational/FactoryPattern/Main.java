package creational.FactoryPattern;

public class Main {
	public static void main(String[] args) {
		Vehicle car = VehicleFactory.getVehicle("Car");
		car.start();
		car.stop();
		Vehicle vehicle = VehicleFactory.getVehicle("Truck");
		vehicle.start();
		vehicle.stop();
	}
}
