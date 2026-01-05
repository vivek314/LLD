package interview.TrafficSignalSystem.domain;

import interview.LoggingFramework.logger.Logger;
import interview.LoggingFramework.logger.LoggerImpl;

import java.util.HashMap;
import java.util.Map;

public class Intersection {
    private int id;
    private String name;
    private Map<Direction, TrafficLight> trafficLights;
    private boolean isEmergencyMode;
    private Direction emergencyDirection;
    private boolean isCyclePaused;

    Logger logger = new LoggerImpl("Intersection logger");

    public Intersection(int id, String name) {
        this.id = id;
        this.name = name;
        trafficLights = new HashMap<>();
        isEmergencyMode = false;
        isCyclePaused = false;
        for  (Direction direction : Direction.values()) {
            trafficLights.put(direction, new TrafficLight(direction));
        }
        logger.info(String.format("Intersection created with id %d and name %s", id, name));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Direction, TrafficLight> getTrafficLights() {
        return trafficLights;
    }

    public Direction getEmergencyDirection() {
        return emergencyDirection;
    }

    public TrafficLight getTrafficLight(Direction direction) {
        return trafficLights.get(direction);
    }

    public void setEmergencyDirection(Direction emergencyDirection) {
        this.emergencyDirection = emergencyDirection;
        logger.info(String.format("Emergency direction set to %s", emergencyDirection));
    }

    public boolean isEmergencyMode() {
        return isEmergencyMode;
    }

    public void setEmergencyMode(boolean emergencyMode) {
        isEmergencyMode = emergencyMode;
        logger.info(String.format("Emergency mode set to %s", isEmergencyMode));
    }

    public boolean isCyclePaused() {
        return isCyclePaused;
    }

    public void setCyclePaused(boolean cyclePaused) {
        isCyclePaused = cyclePaused;
        logger.info(String.format("Cycle paused set to %s", isCyclePaused));
    }

    public void turnAllSignalsToRed() {
        for(TrafficLight trafficLight : trafficLights.values()) {
            String currentState = trafficLight.getTrafficLightState().getState();
            switch (currentState) {
                case "RED":
                    System.out.println("Already in the same state");
                    break;
                case "GREEN":
                    trafficLight.turnYellow();
                    trafficLight.turnRed();
                    break;
                default:
                    trafficLight.turnRed();
                    break;
            }
            return;
        }
    }

    public void turnSignalToGreen(Direction direction) {
        TrafficLight trafficLight = trafficLights.get(direction);
        if(trafficLight != null) {
            trafficLight.turnGreen();
            System.out.println("Changed the traffic light to green for the direction " + direction);
        } else{
            System.out.println("No traffic light found for direction " + direction);
        }
    }
}
