package machinecoding.train;

public class Ticket {

    private static int idGen = 1;
    private int id;
    private int numberOfSeats;
    private Status status;
    private char source;
    private char destination;

    public Ticket( int numberOfSeats, char source, char destination) {
        this.id = idGen++;
        this.numberOfSeats = numberOfSeats;
        this.source = source;
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
}
