package LLD.railway;

import LLD.librarysystem.Book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Repository {

    Map<Integer, Booking> bookingMap;
    private static int[] seats;
    private static int seatLimit;

    public Repository(int seatLimit, int points){
        Repository.seatLimit = seatLimit;
        bookingMap = new HashMap<>();
        seats = new int[points];
        Arrays.fill(seats, seatLimit);
    }
    public static int getSeatLimit() {
        return seatLimit;
    }

    public int[] getSeats(){
        return seats;
    }

    public void saveBooking(int id, Booking booking) {
        bookingMap.put(id, booking);
    }

    public Booking getBookingById(int id) {
        return bookingMap.get(id);
    }

    public void removeBooking(int id) {
        bookingMap.remove(id);
    }


    public void increaseSeats(int seat, char from, char to) {
        for (int points = from - 'A'; points <= to - 'A'; points++){
            seats[points] += seat;
        }
    }

    public void lowerSeats(int seat, char from, char to) {
        for (int points = from - 'A'; points <= to - 'A'; points++){
            seats[points] -= seat;
        }
    }

}
