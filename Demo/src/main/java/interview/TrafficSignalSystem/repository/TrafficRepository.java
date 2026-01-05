package interview.TrafficSignalSystem.repository;

import interview.TrafficSignalSystem.domain.Direction;
import interview.TrafficSignalSystem.domain.VehicleCounter;
import interview.TrafficSignalSystem.exception.TrafficStateException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TrafficRepository {
    private Map<Direction, VehicleCounter> trafficMap;

    public TrafficRepository(){
        trafficMap = new ConcurrentHashMap<>();
        for(Direction direction : Direction.values()){
            trafficMap.put(direction, new VehicleCounter(direction));
        }
        System.out.println("TrafficRepository created with direction created");
    }

    public void updateCounter(Direction direction, int count){
        VehicleCounter vehicleCounter = trafficMap.get(direction);
        if(vehicleCounter == null){
            System.out.println("TrafficRepository.updateCounter: VehicleCounter is null");
            return;
        }
        trafficMap.put(direction, vehicleCounter);
    }

    public VehicleCounter getVehicleCounter(Direction direction){
        if(trafficMap.containsKey(direction)){
            return trafficMap.get(direction);
        } else{
            throw new TrafficStateException("TrafficRepository getVehicleCounter() called with no direction");
        }
    }

    public void incrementCount(Direction direction){
        VehicleCounter vehicleCounter = trafficMap.get(direction);
        if(vehicleCounter == null){
            throw new TrafficStateException("TrafficRepository getVehicleCounter() called with no direction");
        }
        vehicleCounter.incrementCount();
    }

    public void resetCount(Direction direction){
        VehicleCounter vehicleCounter = trafficMap.get(direction);
        if(vehicleCounter == null){
            throw new TrafficStateException("TrafficRepository getVehicleCounter() called with no direction");
        }
        vehicleCounter.resetCount();
    }
}
