package LLD.railwaynew;

import java.util.List;

public class WaitingListManager {

    private char source;
    private char destination;
    private int seats;

    public WaitingListManager(char source, char destination, int seats) {
        this.source = source;
        this.destination = destination;
        this.seats = seats;
    }

    private TicketSystem ticketSystem = TicketSystem.getInstance();

    protected void processWaitingList(){
        List<Ticket> tickets = ticketSystem.getWaitingTickets();
        for (Ticket ticket : tickets){
            if (ticketSystem.checkAvailability(source,destination,seats)){
                ticket.setTicketStatus(TicketStatus.BOOKED);
                ticketSystem.decreaseAvailability(seats,source,destination);
                ticketSystem.addToBooked(ticket.getPnr(), ticket);
            }
        }
    }

    protected void execute(){
        processWaitingList();
    }
}
