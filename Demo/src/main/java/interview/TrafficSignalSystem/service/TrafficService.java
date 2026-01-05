package interview.TrafficSignalSystem.service;

import interview.TrafficSignalSystem.domain.Direction;
import interview.TrafficSignalSystem.domain.TrafficLight;
import interview.TrafficSignalSystem.domain.VehicleCounter;
import interview.TrafficSignalSystem.exception.TrafficStateException;
import interview.TrafficSignalSystem.repository.TrafficRepository;

public class TrafficService {
    private TrafficRepository trafficRepository;

    public TrafficService(TrafficRepository trafficRepository){
        this.trafficRepository = trafficRepository;
    }

    public void updateCount(Direction direction, int count){
        trafficRepository.updateCounter(direction, count);
    }

    public int getCount(Direction direction){
        VehicleCounter vehicleCounter = trafficRepository.getVehicleCounter(direction);
        if(vehicleCounter == null){
            throw new TrafficStateException("TrafficRepository getVehicleCounter() called with no direction");
        }
        return vehicleCounter.getCount();
    }

    public void incrementCount(Direction direction){
        VehicleCounter vehicleCounter = trafficRepository.getVehicleCounter(direction);
        if(vehicleCounter == null){
            throw new TrafficStateException("TrafficRepository getVehicleCounter() called with no direction");
        }
        vehicleCounter.incrementCount();
    }

    public void resetCount(Direction direction){
        VehicleCounter vehicleCounter = trafficRepository.getVehicleCounter(direction);
        if(vehicleCounter == null){
            throw new TrafficStateException("TrafficRepository getVehicleCounter() called with no direction");
        }
        vehicleCounter.resetCount();
    }

    public void detectTrafficCondition(Direction direction) {
        int count = getCount(direction);
        if (count > 10) {
            System.out.println("High traffic detected for " + direction + ": " + count + " vehicles");
            System.out.println("TODO: Trigger dynamic timing adjustment");
        } else if (count == 0) {
            System.out.println("No traffic detected for " + direction);
            System.out.println("TODO: Consider reducing green time for this direction");
        }
    }
}
