package LLD.train;

public class Ticket {
    private static int idGen = 1;

    private int id;
    private String username;
    private SeatType type;
    private int seats;
    private BookingStatus status;

    public Ticket(String username, SeatType type, BookingStatus status, int seats) {
        this.id = idGen++;
        this.seats = seats;
        this.username = username;
        this.type = type;
        this.status = status;
    }

    public Ticket(){}

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }
}
