package interview.ParkingLot.respositories;

import interview.ParkingLot.domain.ParkingSlot;
import interview.ParkingLot.domain.VehicleType;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SlotRepository {
    private Map<UUID, ParkingSlot> slotMap;

    public SlotRepository() {
        this.slotMap = new ConcurrentHashMap<>();
    }

    public void save(ParkingSlot slot) {
        slotMap.put(slot.getId(), slot);
    }

    public Optional<ParkingSlot> findById(UUID id)  {
        return Optional.ofNullable(slotMap.get(id));
    }

    public List<ParkingSlot> findAvailableParkingSlots(VehicleType vehicleType) {
        return slotMap.values().stream().
                filter(slot -> slot.getVehicleType() == vehicleType && !slot.isOccupied()).
                collect(Collectors.toList());
    }

    public Optional<ParkingSlot> allocateSlot(VehicleType vehicleType){
        List<ParkingSlot> allSlots = findAvailableParkingSlots(vehicleType);
        return allSlots.stream().findFirst().map(slot -> {
           slot.setOccupied(true);
           return slot;
        });
    }

    public void releaseSlot(UUID slotUuid) {
        slotMap.computeIfPresent(slotUuid, (id, slot) -> {
            slot.setOccupied(false);
            return slot;
        });
    }


}
