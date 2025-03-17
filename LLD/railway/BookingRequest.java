package LLD.railway;

public class BookingRequest {

    private char source;
    private char destination;
    private int numberOfSeats;

    public BookingRequest(char source, char destination, int numberOfSeats) {
        this.source = source;
        this.destination = destination;
        this.numberOfSeats = numberOfSeats;
    }

    public char getSource() {
        return source;
    }

    public void setSource(char source) {
        this.source = source;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public char getDestination() {
        return destination;
    }

    public void setDestination(char destination) {
        this.destination = destination;
    }
}
