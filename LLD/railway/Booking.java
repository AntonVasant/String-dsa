package LLD.railway;

public class Booking {

    private int bookingId;
    private char source;
    private char destination;
    private int numberOfSeats;
    private int seatsCancelled;

    public int getSeatsCancelled() {
        return seatsCancelled;
    }

    public void addCancelSeats(int seat) {
        setSeatsCancelled(getSeatsCancelled() + seat);
    }

    public void setSeatsCancelled(int seatsCancelled) {
        this.seatsCancelled = seatsCancelled;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
