package LLD.railwaynew;

public class TicketBooking {
    private char source;
    private char destination;
    private int seats;
    private TicketSystem ticketSystem = TicketSystem.getInstance();

    public TicketBooking( char source, char destination, int seats) {
        this.source = source;
        this.destination = destination;
        this.seats = seats;
    }


    private void bookSeats(){
        Ticket ticket = new Ticket(source,destination,seats,TicketStatus.BOOKED);
        int pnr = ticket.getPnr();
        if (ticketSystem.checkAvailability(source,destination,seats)){
            ticketSystem.decreaseAvailability(seats,source,destination);
            ticketSystem.addToBooked(pnr,ticket);
            System.out.println("Ticket booked in confirm list pnr "+pnr);
        }
        else if (ticketSystem.checkWaitingList(seats)){
            ticket.setTicketStatus(TicketStatus.WAITING);
            ticketSystem.addToWaiting(pnr,ticket);
            System.out.println("Added in waiting List pnr "+pnr);
        }
        else System.out.println("Not room to travel");
    }

    protected void execute(){
        bookSeats();
    }

    public char getSource() {
        return source;
    }

    public char getDestination() {
        return destination;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
