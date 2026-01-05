package interview.TrafficSignalSystem.states;

import interview.TrafficSignalSystem.domain.TrafficLight;
import interview.TrafficSignalSystem.exception.TrafficStateException;

public class GreenState implements TrafficLightState {

    @Override
    public void turnToRed(TrafficLight trafficLight) {
        throw new TrafficStateException(trafficLight.getTrafficLightState().getState(), "RED");
    }

    @Override
    public void turnToGreen(TrafficLight trafficLight) {
        System.out.println("Already in the attempted state: " + getState());
    }

    @Override
    public void turnToYellow(TrafficLight trafficLight) {
        trafficLight.setState(new YellowState());
        System.out.println("Changed state from green to yellow");
    }

    @Override
    public void turnToOff(TrafficLight trafficLight) {
        trafficLight.setState(new TurnOffState());
        System.out.println("Changed state from green to off");
    }

    @Override
    public String getState() {
        return "GREEN";
    }
}
