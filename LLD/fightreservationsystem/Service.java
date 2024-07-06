package LLD.fightreservationsystem;

import java.util.Map;
import java.util.UUID;

public class Service {

    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public Ticket bookTicket(String userId,String flightId,SeatType seatType){
        User user = repository.getUserById(userId);
        Flight flight = repository.getFlightById(flightId);
        if (user != null && flight != null){
            Seat seat = getAvailableSeat(flightId,seatType);
            Ticket ticket = generateTicket(flightId,userId,seat);
            return ticket;
        }
        return null;
    }

    public boolean cancelTicket(Ticket ticket){
        Flight flight = ticket.getFlight();
        String seatId  = ticket.getSeat().getSeatId();
        return repository.cancelSeat(seatId,flight);
    }

    public void showAvailableTickets(String flightId){
        repository.showAvailableSeats(flightId);
    }

    private Seat getAvailableSeat(String flight,SeatType seatType){
        Seat seat = repository.getAvailableSeat(flight, seatType);
        return seat;
    }

    private Ticket generateTicket(String flightId,String userId,Seat seat){
        String ticketId = UUID.randomUUID().toString();
        User user = repository.getUserById(userId);
        Flight flight = repository.getFlightById(flightId);
        Ticket ticket = new Ticket(flight,user,ticketId,seat);
        return ticket;
    }
}
