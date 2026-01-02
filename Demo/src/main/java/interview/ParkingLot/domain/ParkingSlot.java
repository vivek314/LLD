package interview.ParkingLot.domain;

import java.util.UUID;

public class ParkingSlot {
    private UUID id;
    private int floorNumber;
    private boolean isOccupied;
    private VehicleType vehicleType;
    public ParkingSlot(int floorNumber, VehicleType vehicleType) {
        this.id = UUID.randomUUID();
        this.floorNumber = floorNumber;
        this.vehicleType = vehicleType;
        this.isOccupied = false;
    }

    public UUID getId() {
        return id;
    }
    public int getFloorNumber() {
        return floorNumber;
    }
    public boolean isOccupied() {
        return isOccupied;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
}
