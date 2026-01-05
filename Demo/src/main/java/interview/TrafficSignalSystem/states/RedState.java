package interview.TrafficSignalSystem.states;

import interview.TrafficSignalSystem.domain.TrafficLight;
import interview.TrafficSignalSystem.exception.TrafficStateException;

public class RedState implements TrafficLightState{

    @Override
    public void turnToRed(TrafficLight trafficLight) {
        System.out.println("Already in the same state: " + "RED");
    }

    @Override
    public void turnToGreen(TrafficLight trafficLight) {
        trafficLight.setState(new GreenState());
        System.out.println("Changed from red to green");
    }

    @Override
    public void turnToYellow(TrafficLight trafficLight) {
        throw new TrafficStateException("RED", trafficLight.getTrafficLightState().getState());
    }

    @Override
    public void turnToOff(TrafficLight trafficLight) {
        trafficLight.setState(new TurnOffState());
        System.out.println("Changed from red to off");
    }

    public String getState() {
        return "RED";
    }
}
