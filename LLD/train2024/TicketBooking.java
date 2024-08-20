package LLD.train2024;

public class TicketBooking {
    private char source;
    private char destination;
    private int seats;

    public TicketBooking(char source, char destination, int seats) {
        this.source = source;
        this.destination = destination;
        this.seats = seats;
    }

    private final TicketBookingSystem bookingSystem = TicketBookingSystem.getInstance();
    private void bookTicket(){
        Ticket ticket = new Ticket(source,destination,seats);
        int pnr = Ticket.getPnrGen();
        if (bookingSystem.checkAvailability(source,destination,seats)){
          ticket.setStatus(TicketStatus.BOOKED);
          bookingSystem.addTobookingList(pnr,ticket);
            bookingSystem.decreaseAvailability(seats,source,destination);
            System.out.println("your seas are confirmed you pnr is "+pnr);
        } else if (bookingSystem.checkWaitingListCapacity(seats)) {
            ticket.setStatus(TicketStatus.WAITING);
            bookingSystem.addToWaitingList(pnr,ticket);
            System.out.println("your ticket is added to waiting list");
        }
        else System.out.println("Ticket not available for "+source+" --> "+destination);
    }

    public void execute(){
        this.bookTicket();
    }
}
