package railway;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TicketBooking {
    private static int totalBerthSeats = 9;
    private static int lowerBerthSeats = totalBerthSeats / 3;
    private static int middleBerthSeats = totalBerthSeats / 3;
    private static int upperrBerthSeats = totalBerthSeats / 3;
    private static int numberOfWaiting = 2;
    private static int numberOfRAC = 2;
    static List<Passengers> confirmedList= new ArrayList<>();
    static List<Passengers> lowerBerthList = new ArrayList<>();
    static List<Passengers> middleBerthList = new ArrayList<>();
    static List<Passengers> upperrBerthList = new ArrayList<>();
    static List<Passengers> waitingList = new ArrayList<>();
    static List<Passengers> RACList = new ArrayList<>();
    static Queue<Passengers> waitngQueue = new LinkedList<>();
    static Queue<Passengers> RACQueue = new LinkedList<>();

    public static void bookTicket(Passengers p) {
        if (upperrBerthSeats == upperrBerthList.size() && lowerBerthSeats == lowerBerthList.size()
                && middleBerthSeats == middleBerthList.size()) {
            if (RACList.size() < numberOfRAC) {
                RACQueue.add(p);
                RACList.add(p);
                System.out.println("Added in RAC category " + p.getSeatId());
            } else if (waitingList.size() < numberOfWaiting) {
                waitingList.add(p);
                waitngQueue.add(p);
                System.out.println("Added in waiting list");
            } else System.out.println("no seats available");
        } else if (checkAvailability(p)){
            displayDetails(p);
            System.out.println("ticket booked");
        }else {
            availableSeats();
        }

    }

    public static boolean checkAvailability(Passengers p) {
        String seat = p.getSeatPreference();
        if (seat.equals("upper") && upperrBerthList.size() < upperrBerthSeats) {
            upperrBerthList.add(p);
            System.out.println("successfully added " + p.getSeatId());
            return true;
        } else if (seat.equals("lower") && lowerBerthList.size() < lowerBerthSeats) {
            lowerBerthList.add(p);
            System.out.println("Added to lower bert " + p.getSeatId());
            return true;
        } else if (seat.equals("middle") && middleBerthList.size() < middleBerthSeats) {
            middleBerthList.add(p);
            System.out.println("Added to lower berth " + p.getSeatId());
            return true;
        } else System.out.println("The category is not available");
        return false;

    }
    private static void availableSeats() {
        int uppers=upperrBerthSeats-upperrBerthList.size();
        int lowers=lowerBerthSeats-lowerBerthList.size();
        int middle=middleBerthSeats-middleBerthList.size();
        System.out.println("Upper berth seats "+uppers);
        System.out.println("Lower berth seats "+lowers);
        System.out.println("Middle berth seats "+middle);
    }

    private static void displayDetails(Passengers p){
        System.out.println("your seat id "+p.getSeatId());
        System.out.println("your passenger id "+p.getPassengerId());
        System.out.println("your seat category "+p.getSeatPreference());
    }
    public static void displayWaiting(){
        for (Passengers p : waitingList){
            System.out.println(p.getName()+" "+p.getSeatPreference());
        }
    }
    public static void displayRAC(){
        for (Passengers p : RACList){
            System.out.println(p.getName()+" "+p.getSeatPreference());
        }
    }
}

