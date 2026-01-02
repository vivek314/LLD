package interview.ParkingLot.controllers;

import interview.ParkingLot.domain.Ticket;
import interview.ParkingLot.domain.Vehicle;
import interview.ParkingLot.domain.VehicleType;
import interview.ParkingLot.services.SlotService;
import interview.ParkingLot.services.TicketService;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class EntryController {
    private TicketService ticketService;
    private SlotService slotService;

    public EntryController(TicketService ticketService, SlotService slotService){
        this.ticketService = ticketService;
        this.slotService = slotService;
        System.out.println("[CONTROLLER] entry controller initialised");
    }

    public static class EntryResult {
        private UUID id;
        private boolean success;
        private String message;
        private UUID slotUuid;
        private UUID ticketUuid;
        public EntryResult(boolean success, String message, UUID slotUuid, UUID ticketUuid) {
            this.id = UUID.randomUUID();
            this.success = success;
            this.message = message;
            this.slotUuid = slotUuid;
            this.ticketUuid = ticketUuid;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }

        public UUID getSlotUuid() {
            return slotUuid;
        }

        public UUID getTicketId() {
            return ticketUuid;
        }
    }

    public EntryResult enterVehicle(String licensePlate, VehicleType vehicleType){
        Vehicle vehicle = new Vehicle(licensePlate, vehicleType);

        System.out.println("[CONTROLLER] Vehicle created: " + vehicle.getId());

        Optional<UUID> slotUuid = slotService.allocateSlot(vehicleType).map(slot -> slot.getId());
        if(slotUuid.isEmpty()){
            System.out.println("[CONTROLLER] Slot not allocated");
            return new EntryResult(false, "Slot not allocated", null, null);
        }
        Ticket ticket = ticketService.generateTicket(vehicle.getId(), slotUuid.get());
        System.out.println("Slot got allocated for Vechicle, Ticket: " + ticket.getId() + " Slot - " + slotUuid);
        return new EntryResult(true, "Entry successful", slotUuid.get(), ticket.getId());
    }
}
