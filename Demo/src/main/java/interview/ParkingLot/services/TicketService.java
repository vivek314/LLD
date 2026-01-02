package interview.ParkingLot.services;

import interview.ParkingLot.domain.Ticket;
import interview.ParkingLot.domain.Vehicle;
import interview.ParkingLot.respositories.TicketRepository;

import java.util.Optional;
import java.util.UUID;

public class TicketService {
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Optional<Ticket> findById(UUID id) {
        System.out.println("Finding Ticket by ID: " + id);
        Optional<Ticket> ticket = ticketRepository.getTicket(id);
        if(ticket.isEmpty()){
            System.out.println("Ticket not found");
        }
        else{
            System.out.println("Ticket found");
        }
        return ticket;
    }

    public Ticket generateTicket(UUID vehicleUuid, UUID slotUuid) {
        Ticket ticket = new Ticket(vehicleUuid, slotUuid);
        System.out.println("Generated Ticket: " + ticket.getId() + " Slot - " + slotUuid);
        ticketRepository.save(ticket);
        return ticket;
    }

    public void deactivateTicket(UUID  ticketId) {
        System.out.println("Deactivating Ticket: " + ticketId);
        ticketRepository.deactivateTicket(ticketId);
        System.out.println("Ticket deactivated: " +  ticketId);
    }
}
