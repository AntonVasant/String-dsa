package LLD.fightreservationsystem;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    Map<String,User> usersMap = new HashMap<>();
    Map<String,Flight> flightMap = new HashMap<>();

    Map<String,Seat> flightSeats = new HashMap<>();
    public Repository(){
        Flight flight1 = new Flight("FL123", "Air India", "New York", "Los Angeles",
                LocalDateTime.of(2024, 8, 15, 10, 30),
                LocalDateTime.of(2024, 8, 15, 13, 45));

        // Create second flight
        Flight flight2 = new Flight("FL456", "British Airways", "London", "Tokyo",
                LocalDateTime.of(2024, 9, 10, 22, 0),
                LocalDateTime.of(2024, 9, 11, 14, 30));
        flightMap.put("FL123",flight1);
        flightMap.put("FL456",flight2);

        flight1.addSeat("1A", new Seat("1A", true));
        flight1.addSeat("1B", new Seat("1B", true));

        flight2.addSeat("10A", new Seat("10A", true));
        flight2.addSeat("10B", new Seat("10B", false));
    }

    public User getUserById(String userId){
        return usersMap.get(userId);
    }

    public Flight getFlightById(String flightId){
        return flightMap.get(flightId);
    }

    public void showAvailableSeats(String flightId){
        for (Seat seat : flightSeats.values()){
            if (seat.isAvailable()){
                System.out.println(seat.getSeatId()+" "+seat.getSeatType());
            }
        }
    }

    public boolean cancelSeat(String seatId,Flight flight){
        Map<String,Seat> seats = flight.getSeats();
        Seat seat = seats.get(seatId);
        if (seat != null){
            seat.setAvailable(true);
            return true;
        }
            return false;
    }

    public Seat getAvailableSeat(String flightId,SeatType  seatType){
        for (Seat seat : flightSeats.values()){
            if (seat.isAvailable() && seatType == seat.getSeatType()){
                seat.setAvailable(false);
                return seat;
            }
        }
        return null;
    }

    public void createUser(User user,String id){
        usersMap.put(id,user);
    }
}
