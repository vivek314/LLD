package interview.ParkingLot.respositories;

import interview.ParkingLot.domain.ParkingFloor;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class FloorRepository {
    private Map<UUID, ParkingFloor> floorMap = new ConcurrentHashMap<>();
    private Map<Integer, UUID> floorToId = new ConcurrentHashMap<>();

    public ParkingFloor save(ParkingFloor floor){
        floorMap.put(floor.getId(), floor);
        floorToId.put(floor.getFloorNumber(), floor.getId());
        return floor;
    }

    public Optional<ParkingFloor> findById(UUID id){
        return  Optional.ofNullable(floorMap.get(id));
    }

    public Optional<ParkingFloor> findByFloorNumber(int floorNumber){
        UUID floorId = floorToId.get(floorNumber);
        return findById(floorId);
    }

    public boolean containsKey(int floorNumber){
        return floorToId.containsKey(floorNumber);
    }
}
