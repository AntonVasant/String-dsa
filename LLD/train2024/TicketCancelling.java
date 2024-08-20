package LLD.train2024;

public class TicketCancelling {
    private int pnr;
    private int seats;
    private final TicketBookingSystem bookingSystem = TicketBookingSystem.getInstance();

    public TicketCancelling(int pnr, int seats) {
        this.pnr = pnr;
        this.seats = seats;
    }

    public void execute(){
        this.ticketCancelling();
    }

    private void ticketCancelling(){
        Ticket ticket = bookingSystem.getTicketByPnr(pnr);
        if (ticket == null){
            System.out.println("no ticket found");
            return;
        }
        char source = ticket.getSource();
        char destination = ticket.getDestination();
        int seatsBooked = ticket.getSeas();
        if (ticket.getStatus() == TicketStatus.WAITING){
            bookingSystem.removeFromWaiting(pnr);
            return;
        }
        if (seatsBooked== seats) {
            bookingSystem.removeFromBooking(pnr);
        }
        else {
            bookingSystem.storePartiallyCancelledSeats(pnr,seats);
        }
        bookingSystem.increaseAvailability(seats,ticket.getSource(), ticket.getDestination());
        bookingSystem.processWaitingList(source,destination,seats);
    }
}
