package interview.TrafficSignalSystem.controller;

import interview.TrafficSignalSystem.domain.Direction;
import interview.TrafficSignalSystem.service.TrafficService;

public class TrafficController {
    private TrafficService trafficService;

    public TrafficController(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    public void updateVehicleCount(Direction direction, int count){
        System.out.println("Updating vehicle count for direction: " + direction);
        trafficService.updateCount(direction, count);
    }

    public int getVehicleCount(Direction direction){
        System.out.println("Getting vehicle count for direction: " + direction);
        return trafficService.getCount(direction);
    }

    public void getTrafficCondition(Direction direction){
        System.out.println("Getting traffic for direction: " + direction);
        trafficService.detectTrafficCondition(direction);
    }

    public void incrementCount(Direction direction){
        System.out.println("Incrementing traffic for direction: " + direction);
        trafficService.incrementCount(direction);
    }

    public void resetCount(Direction direction){
        System.out.println("Resetting traffic for direction: " + direction);
        trafficService.resetCount(direction);
    }
}
