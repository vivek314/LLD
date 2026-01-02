package interview.ParkingLot.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final UUID slotId;
    private final UUID vehicleId;
    private final UUID id;
    private final LocalDateTime entryTime;
    private boolean isActive;

    public Ticket(UUID vehicleId, UUID slotId) {
        this.slotId = slotId;
        this.vehicleId = vehicleId;
        this.id = UUID.randomUUID();
        this.entryTime = LocalDateTime.now();
        this.isActive = true;
    }

    public UUID getId(){
        return id;
    }

    public LocalDateTime getEntryTime(){
        return entryTime;
    }
    public UUID getVehicleId(){
        return vehicleId;
    }
    public UUID getSlotId(){
        return slotId;
    }
    public boolean isActive(){
        return isActive;
    }
    public void setInactive(boolean active){
        this.isActive = active;
    }
}
