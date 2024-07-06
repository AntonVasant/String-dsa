package LLD.fightreservationsystem;

public class Ticket {
    private String TicketId;
    private User user;
    private Flight flight;
    private Seat seat;

    public Ticket(Flight flight,User user,String ticketId,Seat seat) {
        this.flight = flight;
        this.seat = seat;
        this.TicketId = ticketId;
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
