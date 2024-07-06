package LLD.fightreservationsystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    Map<String,User> usersMap = new HashMap<>();
    Map<String,Flight> flightMap = new HashMap<>();

    Map<String,Seat> flightSeats = new HashMap<>();


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
}
