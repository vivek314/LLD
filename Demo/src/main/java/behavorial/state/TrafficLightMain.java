package behavorial.state;

public class TrafficLightMain {
	public static void main(String[] args) {
		StateContext context = new StateContext();
		System.out.println(context.getState());
		context.next();
		System.out.println(context.getState());
	}
}
