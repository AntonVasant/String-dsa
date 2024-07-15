package LLD.railway;

public class Ticket {
    private int ticketId;
    private String seatType;
    private Passenger passenger;
    private char berthType;

    public Ticket(Passenger passenger,String seatType, char berthType) {
        this.passenger = passenger;
        this.seatType = seatType;
        this.berthType= berthType;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public char getBerthType() {
        return berthType;
    }

    public void setBerthType(char berthType) {
        this.berthType = berthType;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
