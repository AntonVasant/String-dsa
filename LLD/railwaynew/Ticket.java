package LLD.railwaynew;

import com.sun.jdi.PrimitiveValue;

public class Ticket {

    private static int pnrGenerator = 1;

    private int pnr;
    private char source;
    private char destination;
    private int seats;
    private TicketStatus ticketStatus;

    public Ticket( char source, char destination, int seats, TicketStatus ticketStatus) {
        this.pnr = pnrGenerator++;
        this.source = source;
        this.destination = destination;
        this.seats = seats;
        this.ticketStatus = ticketStatus;
    }


    public int getPnr() {
        return pnr;
    }

    public void setPnr(int pnr) {
        this.pnr = pnr;
    }

    public char getSource() {
        return source;
    }

    public void setSource(char source) {
        this.source = source;
    }

    public char getDestination() {
        return destination;
    }

    public void setDestination(char destination) {
        this.destination = destination;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
