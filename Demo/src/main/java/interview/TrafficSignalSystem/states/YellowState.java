package interview.TrafficSignalSystem.states;
import interview.TrafficSignalSystem.domain.TrafficLight;
import interview.TrafficSignalSystem.exception.TrafficStateException;

public class YellowState implements TrafficLightState {

    @Override
    public void turnToRed(TrafficLight trafficLight) {
        trafficLight.setState(new RedState());
        System.out.println("Changed from Yellow to red");
    }


    @Override
    public void turnToGreen(TrafficLight trafficLight) {
        throw new TrafficStateException(getState(), trafficLight.getTrafficLightState().getState());
    }

    @Override
    public void turnToYellow(TrafficLight trafficLight) {
        System.out.println("Already in the same state: " + getState());
    }

    @Override
    public void turnToOff(TrafficLight trafficLight) {
        trafficLight.setState(new TurnOffState());
        System.out.println("Changed from Yellow to off");
    }

    @Override
    public String getState() {
        return "YELLOW";
    }
}
