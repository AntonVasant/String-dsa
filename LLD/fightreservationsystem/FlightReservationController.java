package LLD.fightreservationsystem;

public class FlightReservationController {

    private Service service;

    public FlightReservationController(Service service) {
        this.service = service;
    }

    public Ticket bookTicket(String userId,String flightId,SeatType seat){
        return service.bookTicket(userId,flightId,seat);
    }

    public String cancelTicket(Ticket ticket){
        boolean status = service.cancelTicket(ticket);
        if (status) return "Cancelled SuccessFully";
        return "User not found";
    }

    public void showAvailableSeats(String flightId){
        service.showAvailableTickets(flightId);
    }
}
