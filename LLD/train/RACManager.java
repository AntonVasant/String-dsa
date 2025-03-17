package LLD.train;

import java.util.LinkedList;
import java.util.Queue;

public class RACManager {

    private static Queue<BookingRequest> requestQueue;
    private BookingManager manager;
    private int capacity;

    public RACManager(int capacity){
        requestQueue = new LinkedList<>();
        this.capacity = capacity;
    }
    public void addToRacQueue(BookingRequest request){
        requestQueue.offer(request);
    }

    public boolean isAvailable(int count){
        return requestQueue.size() + count <= capacity;
    }


    public void moveToConfirmedStatus(int count){
        while (!requestQueue.isEmpty() && count > 0){
            manager.bookTicket(requestQueue.poll());
        }
    }
}
