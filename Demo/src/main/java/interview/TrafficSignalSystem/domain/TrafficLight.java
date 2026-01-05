package interview.TrafficSignalSystem.domain;

import interview.TrafficSignalSystem.states.RedState;
import interview.TrafficSignalSystem.states.TrafficLightState;

import java.util.UUID;

public class TrafficLight {
    private final UUID id;
    private TrafficLightState trafficLightState;
    private Direction direction;

    public TrafficLight(Direction direction) {
        this.id = UUID.randomUUID();
        this.trafficLightState = new RedState();
        this.direction = direction;
    }

    public UUID getId() { return id; }
    public void setState(TrafficLightState trafficLightState){
        this.trafficLightState = trafficLightState;
    }
    public TrafficLightState getTrafficLightState(){
        return trafficLightState;
    }

    public Direction getDirection() {
        return direction;
    }

    public void turnYellow(){
        trafficLightState.turnToYellow(this);
    }

    public void turnRed(){
        trafficLightState.turnToRed(this);
    }

    public void turnGreen(){
        trafficLightState.turnToGreen(this);
    }

    public void turnOff(){
        trafficLightState.turnToOff(this);
    }

}
