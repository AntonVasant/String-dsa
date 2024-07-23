package LLD.fightreservationsystem;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flight {
    private String flightId;
    private String flightName;
    private String origin;
    private String destination;
    private LocalDateTime departure;
    private LocalDateTime arrival;
    Map<String,Seat> seats;

    public Flight(String id,String name,String origin,String destination,LocalDateTime departure, LocalDateTime arrival) {
        this.arrival = arrival;
        this.departure = departure;
        this.flightName = name;
        this.origin = origin;
        this.destination = destination;
        this.flightId = id;
        seats = new HashMap<>();
    }

    public Map<String, Seat> getSeats() {
        return seats;
    }

    public void setSeats(Map<String, Seat> seats) {
        this.seats = seats;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {

        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void addSeat(String s, Seat seat) {
        seats.put(s,seat);
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }
}
