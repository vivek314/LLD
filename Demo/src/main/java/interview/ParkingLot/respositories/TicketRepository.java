package interview.ParkingLot.respositories;

import interview.ParkingLot.domain.Ticket;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TicketRepository {
    private Map<UUID, Ticket> ticketMap;
    public TicketRepository() {
        ticketMap = new ConcurrentHashMap<>();
    }
    public Optional<Ticket> getTicket(UUID id) {
        return Optional.ofNullable(ticketMap.get(id));
    }
    public Ticket save(Ticket ticket) {
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }
    public List<Ticket> getActiveTickets() {
        return ticketMap.values().stream().filter(Ticket::isActive).collect(Collectors.toList());
    }
    public void deactivateTicket(UUID ticketId) {
        ticketMap.computeIfPresent(ticketId, (id, ticket) -> {
            ticket.setInactive(false);
            return ticket;
        });
    }


}
