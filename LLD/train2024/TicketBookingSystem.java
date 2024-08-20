package LLD.train2024;

import greedy.MinimumMovesToAssignArrayNumberaEqual;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TicketBookingSystem {
    private static TicketBookingSystem instance;

    public static TicketBookingSystem getInstance(){
        if (instance == null)
            instance = new TicketBookingSystem();
        return instance;
    }
    private final int waitingLimit = 5;
    private static Map<Integer,Ticket> bookedSeats = new HashMap<>();
    private static Map<Integer,Integer> cancelledSeats = new HashMap<>();
    private static ConcurrentHashMap<Integer,Ticket> waitinglist  = new ConcurrentHashMap<>();

    
    private int [] totalSeats = new int[5];
    private TicketBookingSystem(){
        Arrays.fill(totalSeats, 8);
    }
    public boolean checkAvailability(char source,char destination,int seats){
        for (int i = source-'A'; i < destination- 'A'; i++){
            if (totalSeats[i] < seats) return false;
        }
        return true;
    }

    public void increaseAvailability(int seats,char source,char destination){
        for (int i = source-'A'; i < destination-'A';i++){
            totalSeats[i] += seats;
        }
    }

    public void decreaseAvailability(int seats,char source,char destination){
        for (int i = source-'A'; i < destination-'A';i++){
            totalSeats[i] -= seats;
        }
    }

    public boolean checkWaitingListCapacity(int seats){
        return getWaitingListCount() + seats <= waitingLimit;
    }
    public void addToWaitingList(int pnr,Ticket ticket){
        waitinglist.put(pnr,ticket);
    }
    private int getWaitingListCount(){
        int n = 0;
        for (Ticket ticket : waitinglist.values())
            n += ticket.getSeas();
        return n;
    }

    public void addTobookingList(int pnr, Ticket ticket) {
        bookedSeats.put(pnr,ticket);
    }

    public Ticket getTicketByPnr(int pnr) {
        if (bookedSeats.containsKey(pnr))
            return bookedSeats.get(pnr);
        else if (waitinglist.containsKey(pnr)) {
            return waitinglist.get(pnr);
        }
        return null;
    }

    public void removeFromWaiting(int pnr) {
        waitinglist.remove(pnr);
    }

    public void removeFromBooking(int pnr) {
        bookedSeats.remove(pnr);
    }

    public void storePartiallyCancelledSeats(int pnr, int seats) {
        cancelledSeats.put(pnr,cancelledSeats.getOrDefault(pnr,0)+seats);
    }

    public void processWaitingList(char source, char destination, int seats) {
        boolean isValid = false;
        for (int pnr : waitinglist.keySet()){
            Ticket ticket = waitinglist.get(pnr);
            if (ticket.getSource() >= source & ticket.getDestination() <= destination && ticket.getSeas() <= seats)
                isValid = true;
            if (isValid){
                addTobookingList(pnr,ticket);
                decreaseAvailability(seats,source,destination);
                removeFromWaiting(pnr);
                System.out.println("ticket confirmed and moved to booked list pnr "+pnr);
            }
        }
    }
    public void displayChart(){
        System.out.println("Available seats are "+Arrays.toString(totalSeats));
        System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8");
       for (char c = 'A'; c < 'F'; c++){
           System.out.print(c);
           int times = 8 - totalSeats[c-'A'];
            for (int i = 0; i < times; i++){
                System.out.print("\t*");
            }
           System.out.println();
       }
    }
}
