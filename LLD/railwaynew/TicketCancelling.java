package LLD.railwaynew;

public class TicketCancelling {

    private int pnr;
    private int seats;
    private TicketSystem ticketSystem = TicketSystem.getInstance();

    public TicketCancelling(int pnr, int seats) {
        this.pnr = pnr;
        this.seats = seats;
    }

    private void cancelTicket(){
        Ticket ticket = ticketSystem.getTicket(pnr);
        char source = ticket.getSource();
        char destination = ticket.getDestination();
        WaitingListManager waitingListManager = new WaitingListManager(source,destination,seats);
        int totalSeats = ticket.getSeats();
        if (ticket.getTicketStatus() == TicketStatus.BOOKED){
            if (totalSeats > seats){
                ticket.setSeats(totalSeats - seats);
            }
            else
                ticketSystem.removeFromBooking(pnr);
            ticketSystem.increaseAvailability(seats,source,destination);
            waitingListManager.execute();
            System.out.println("Cancelled seats pnr "+pnr+" No. of seats "+seats);
        }
    }

    protected void execute(){
        cancelTicket();
    }
}
