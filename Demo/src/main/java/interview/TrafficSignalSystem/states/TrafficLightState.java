package interview.TrafficSignalSystem.states;


import interview.TrafficSignalSystem.domain.TrafficLight;

public interface TrafficLightState {
    void turnToRed(TrafficLight trafficLight);
    void turnToGreen(TrafficLight trafficLight);
    void turnToYellow(TrafficLight trafficLight);
    void turnToOff(TrafficLight trafficLight);
    String getState();
}
