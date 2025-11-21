package creational.builderDesignPattern;

public class Car {
	private String engine;
	private int wheels;
	private int seats;
	private String color;
	private boolean sunRoof;
	private boolean navigationSystem;

	private Car(CarBuilder builder){
		this.engine = builder.engine;
		this.wheels = builder.wheels;
		this.seats = builder.seats;
		this.color = builder.color;
		this.sunRoof = builder.sunRoof;
		this.navigationSystem = builder.navigationSystem;
	}

	public String getEngine() {
		return engine;
	}
	public int getSeats() {
		return seats;
	}
	public int getWheels() {
		return wheels;
	}
	public String getColor() {
		return color;
	}
	public boolean hasSunroof(){
		return sunRoof;
	}
	public boolean hasNavigationSystem(){
		return navigationSystem;
	}

	public static class CarBuilder{
		private String engine;
		private int wheels;
		private int seats;
		private String color;
		private boolean sunRoof;
		private boolean navigationSystem;

		public CarBuilder(){
			engine = "suzuki";
			wheels = 4;
			seats = 4;
			color = "red";
			sunRoof = true;
			navigationSystem = true;
		}

		public CarBuilder addEngine(String engine){
			this.engine = engine;
			return this;
		}
		public CarBuilder addWheels(int wheels){
			this.wheels = wheels;
			return this;
		}
		public CarBuilder addSeats(int seats){
			this.seats = seats;
			return this;
		}
		public CarBuilder addColor(String color){
			this.color = color;
			return this;
		}
		public CarBuilder addSunRoof(boolean sunRoof){
			this.sunRoof = sunRoof;
			return this;
		}
		public CarBuilder addNavigationSystem(boolean navigationSystem){
			this.navigationSystem = navigationSystem;
			return this;
		}
		public Car build(){
			return new Car(this);
		}
	}

	public static void main(String[] args) {
		Car.CarBuilder builder = new Car.CarBuilder();
		Car car1 = builder.addColor("red").addSeats(4).build();
		System.out.println(car1.getWheels());
	}
}
