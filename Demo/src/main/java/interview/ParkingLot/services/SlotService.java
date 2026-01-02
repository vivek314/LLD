package interview.ParkingLot.services;

import interview.ParkingLot.domain.ParkingSlot;
import interview.ParkingLot.domain.VehicleType;
import interview.ParkingLot.respositories.SlotRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SlotService {
    private final SlotRepository slotRepository;
    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public Optional<ParkingSlot> allocateSlot(VehicleType vehicleType) {
        System.out.println("[SLOT SERVICE] Trying to allocate seat for type: " + vehicleType);
        Optional<ParkingSlot> slot = slotRepository.allocateSlot(vehicleType);
        if(slot.isEmpty()){
            System.out.println("[SLOT SERVICE] No slots found for the type: " + vehicleType);
        } else{
            System.out.println("[SLOT SERVICE] Allocated slot for the type: " + vehicleType);
        }
        return slot;
    }

    public List<ParkingSlot> getAllAvailableSlots(VehicleType vehicleType) {
        System.out.println("[SLOT SERVICE] Trying to get available   slots for vehicle type: " + vehicleType);
        return slotRepository.findAvailableParkingSlots(vehicleType);
    }

    public void releaseSlot(UUID slotUuid) {
        System.out.println("[SLOT SERVICE] Trying to release slot for slot id: " + slotUuid);
        slotRepository.releaseSlot(slotUuid);
        System.out.println("[SLOT SERVICE] Slot released: " + slotUuid);
    }

    public void addSlot(ParkingSlot slot) {
        slotRepository.save(slot);
    }

}
