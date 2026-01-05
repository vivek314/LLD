package interview.TrafficSignalSystem.states;

import interview.TrafficSignalSystem.domain.TrafficLight;

public class TurnOffState implements TrafficLightState {

    @Override
    public void turnToRed(TrafficLight trafficLight) {
        trafficLight.setState(new RedState());
        System.out.println("Changed from off to red");
    }

    @Override
    public void turnToGreen(TrafficLight trafficLight) {
        trafficLight.setState(new GreenState());
        System.out.println("Changed from off to green");
    }

    @Override
    public void turnToYellow(TrafficLight trafficLight) {
        trafficLight.setState(new YellowState());
        System.out.println("Changed from off to yellow");
    }

    @Override
    public void turnToOff(TrafficLight trafficLight) {
        System.out.println("Already in the same state: " + getState());
    }

    @Override
    public String getState() {
        return "OFF";
    }
}
