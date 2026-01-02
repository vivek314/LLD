package interview.ParkingLot.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingFloor {
    private UUID id;
    private int floorNumber;
    private final List<ParkingSlot> parkingSlots;

    public ParkingFloor(int floorNumber) {
        this.id = UUID.randomUUID();
        this.floorNumber = floorNumber;
        this.parkingSlots = new ArrayList<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }
    public void addParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlots.add(parkingSlot);
    }
    public void removeParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlots.remove(parkingSlot);
    }
    public UUID getId() {
        return id;
    }
}
