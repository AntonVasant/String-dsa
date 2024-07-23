package LLD.railway2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Repository {

    private static List<Passenger> upperBerthList = new ArrayList<>();
    private static List<Passenger> middleBerthList = new ArrayList<>();

    private static List<Passenger> lowerBerthList = new ArrayList<>();
    private static Queue<Passenger> RACLQueue  = new LinkedList<>();
    private static Queue<Passenger> waitingQueue = new LinkedList<>();

    private static List<Passenger> confirmedList = new ArrayList<>();
    public void addUpper(Passenger passenger){
        upperBerthList.add(passenger);
    }

    public Passenger getPassengerById(int id){
        for (Passenger p : confirmedList){
            if (id == p.getSeat().getSeatId())
                return p;
        }
        return null;
    }

    public Passenger moveWaitingToRac(){
        if (!waitingQueue.isEmpty())
            return waitingQueue.poll();
        return null;
    }

    public Passenger moveRacToConfirm(){
        if (!RACLQueue.isEmpty())
            return RACLQueue.poll();
        return null;
    }
    public void removeFromConfirm(Passenger passenger){
        confirmedList.remove(passenger);
    }
    public List<Passenger> getAllConfirmList(){
        return confirmedList;
    }
    public void addConfirmList(Passenger passenger){
        confirmedList.add(passenger);
    }
    public void addLower(Passenger passenger){
        lowerBerthList.add(passenger);
    }
    public void addMiddle(Passenger passenger){
        middleBerthList.add(passenger);
    }
    public void addRAC(Passenger passenger){
        RACLQueue.offer(passenger);
    }

    public int racLimit(){
        return RACLQueue.size();
    }

    public void addWaiting(Passenger passenger){
        waitingQueue.offer(passenger);
    }

    public int getLowerBerthCount(){
        return lowerBerthList.size();
    }
    public int getMiddleBerthCount(){
        return middleBerthList.size();
    }
    public int getUpperBerthCount(){
        return upperBerthList.size();
    }

    public int getWaitingList(){
        return waitingQueue.size();
    }
}
