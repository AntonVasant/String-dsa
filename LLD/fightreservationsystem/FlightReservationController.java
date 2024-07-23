package LLD.fightreservationsystem;

import org.w3c.dom.ls.LSResourceResolver;

public class FlightReservationController {

    private Service service;

    public FlightReservationController(Service service) {
        this.service = service;
    }

    public void bookTicket(String userId,String flightId,SeatType seat){
        Ticket ticket =  service.bookTicket(userId,flightId,seat);
        System.out.println("your flight name  "+ticket.getFlight().getFlightName());
    }

    public String cancelTicket(Ticket ticket){
        boolean status = service.cancelTicket(ticket);
        if (status) return "Cancelled SuccessFully";
        return "User not found";
    }

    public void showAvailableSeats(String flightId){
        service.showAvailableTickets(flightId);
    }

    public void creatUser(String name,String email){
       User user =  service.createUser(name,email);
        System.out.println("your id "+user.getUserId());
    }
}
