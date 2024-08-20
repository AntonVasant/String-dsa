package LLD.train2024;

public class Ticket {
    private static int pnrGen = 1;
    private int seas;
    private char source;
    private char destination;
    private TicketStatus status;

    public Ticket(char source,char destination,int seats) {
        this.source = source;
        this.destination = destination;
        this.seas = seats;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public char getSource() {
        return source;
    }

    public void setSource(char source) {
        this.source = source;
    }

    public int getSeas() {
        return seas;
    }

    public void setSeas(int seas) {
        this.seas = seas;
    }

    public static int getPnrGen() {
        return pnrGen++;
    }


    public char getDestination() {
        return destination;
    }

    public void setDestination(char destination) {
        this.destination = destination;
    }
}
