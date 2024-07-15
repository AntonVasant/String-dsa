package LLD.railway;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Repository {

    static Queue<Ticket> queueRAC = new LinkedList<>();
    static Queue<Passenger> queueWaiting = new LinkedList<>();
    static List<Ticket> confirmedTicket = new ArrayList<>();

    static List<Ticket> middleBerth = new ArrayList<>();

    public List<Ticket> getUpperBerth() {
        return upperBerth;
    }

    public void setUpperBerth(List<Ticket> upperBerth) {
        this.upperBerth = upperBerth;
    }

   static List<Ticket> upperBerth = new ArrayList<>();
    static List<Ticket> lowerBerth = new ArrayList<>();


//    public Ticket moveRacToSeat(){
//        Ticket ticket = queueRAC.poll();
//
//    }

    public void addToConfirm(Ticket ticket){
        confirmedTicket.add(ticket);
    }

    public void addWaiting(Passenger passenger){
        queueWaiting.offer(passenger);
    }

    public Queue<Ticket> getQueueRAC() {
        return queueRAC;
    }

    public Queue<Passenger> getQueueWaiting() {
        return queueWaiting;
    }

    public void setQueueWaiting(Queue<Passenger> queueWaiting) {
        this.queueWaiting = queueWaiting;
    }

    public void setQueueRAC(Queue<Ticket> queueRAC) {
        this.queueRAC = queueRAC;
    }

    public List<Ticket> getLowerBerth() {
        return lowerBerth;
    }

    public List<Ticket> getMiddleBerth() {
        return middleBerth;
    }

    public void setMiddleBerth(List<Ticket> middleBerth) {
        this.middleBerth = middleBerth;
    }

    public void setLowerBerth(List<Ticket> lowerBerth) {
        this.lowerBerth = lowerBerth;
    }

    public List<Ticket> getConfirmedTicket() {
        return confirmedTicket;
    }

    public void setConfirmedTicket(List<Ticket> confirmedTicket) {
        this.confirmedTicket = confirmedTicket;
    }
}
