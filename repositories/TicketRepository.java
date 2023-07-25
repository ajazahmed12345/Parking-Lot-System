package parkingLot_Practice.repositories;

import parkingLot_Practice.models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    private Map<Long, Ticket> tickets = new TreeMap<>();
    private Long prevId = 0L;
    public Ticket saveTicket(Ticket ticket){
        prevId += 1;
        ticket.setId(prevId);
        tickets.put(prevId, ticket);

        return ticket;
    }
}
