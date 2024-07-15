package LLD.railway;

public class Controller {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }


    public Ticket bookTicket(Passenger passenger){
        Ticket ticket =service.bookTicket(passenger);
        return ticket;
    }

    public void printBookedTickets(){
        service.printBookedSeats();
    }
}
