package bus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookTicket {
    static Map<Integer,String> seats = new HashMap<>();
    static List<Passenger> passengers = new ArrayList<>();
    static List<Integer> available = new ArrayList<>();
    public static void bookTicket(Passenger passenger){
        if (checkAvailability(passenger.getSeatNumber())){
            seats.put(passenger.getSeatNumber(), passenger.getName());
            passengers.add(passenger);
            available.add(passenger.getSeatNumber());
            System.out.println("Successfully booked "+passenger.getSeatNumber());
        }else System.out.println("seat not available");
    }
    public static void cancel(int id){
        if(valid(id)){
            seats.remove(id);
            System.out.println("cancelled successfully");
        }else System.out.println("Not a valid seat number to cancel");

    }
    private static boolean valid(int number){
        return seats.containsKey(number);
    }
    private static boolean checkAvailability(int seatNumber){
        if(seats.containsKey(seatNumber)){
            return false;
        }else return true;
    }
    public static void displaySeats(){
         for (Passenger p : passengers){
             System.out.println(p.getSeatNumber());
         }
    }
    public static void displayBooking(){
         for (Integer num : available){
             System.out.println(num+" ");
         }
    }
}
