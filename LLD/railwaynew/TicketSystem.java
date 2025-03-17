package LLD.railwaynew;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TicketSystem {

    private static TicketSystem ticketSystem;
    private static final int waitingListLimit = 5;

    private static Map<Integer,Ticket> ticketBooked = new HashMap<>();
    private static Map<Integer,Ticket> cancelledTickets = new HashMap<>();
    private static ConcurrentHashMap<Integer,Ticket> waitingTickets = new ConcurrentHashMap<>();

    private static Map<Integer, Ticket> partiallyCancelledTickets = new HashMap<>();
    private static int[] seats = new int[5];

    private TicketSystem(){
        Arrays.fill(seats,8);
    }
    public static TicketSystem getInstance(){
        if (ticketSystem == null)
            ticketSystem = new TicketSystem();
        return ticketSystem;
    }

    protected void storePartiallyCancelled(int pnr,Ticket ticket){

    }
    protected Ticket getTicket(int pnr){
        if (ticketBooked.containsKey(pnr))
            return ticketBooked.get(pnr);
        else return waitingTickets.get(pnr);
    }

    protected void addToBooked(int pnr,Ticket ticket){
        ticketBooked.put(pnr,ticket);
    }

    protected void addToCancel(int pnr,Ticket ticket){
        cancelledTickets.put(pnr,ticket);
    }

    protected void addToWaiting(int pnr,Ticket ticket){
        waitingTickets.put(pnr,ticket);
    }

    protected void removeFromBooking(int pnr){
        ticketBooked.remove(pnr);
    }

    protected boolean checkWaitingList(int seats){
        return waitingTickets.size() + seats < waitingListLimit;
    }

    protected List<Ticket> getWaitingTickets(){
        return new ArrayList<>(waitingTickets.values());
    }

    protected void increaseAvailability(int seat,char source, char destination){
        for (char a = source; a < destination; a++)
            seats[a- 'A'] += seat;
    }

    protected void decreaseAvailability(int seat,char source, char destination){
        for (char a = source; a < destination; a++)
            seats[a - 'A'] -= seat;
    }

    protected boolean checkAvailability(char source, char destination,int seat){
        for (char a = source; a < destination; a++){
            if (seats[a - 'A'] < seat)
                return false;
        }
        return true;
    }

    protected void displayTickets(){
        System.out.println("\n Seats Booked");
        ticketBooked.values().forEach(System.out::println);
        System.out.println("\n Waiting Tickets");
        waitingTickets.values().forEach(System.out::println);
        System.out.println("Available tickets are");
        for (char a = 'A'; a < 'E'; a++){
            System.out.print(a+"\t");
        }
        System.out.println();
        for (int seat : seats) {
            System.out.print(seat + "\t");
        }
        for (int i = 0; i < seats.length; i++){
            System.out.print((char)('A'+i)+"\t");
            int stars = 8 - seats[i];
            for (int j = 0; j < stars; j++)
                System.out.print("*\t");
            System.out.println();
        }
    }
}
