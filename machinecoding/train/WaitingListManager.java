package machinecoding.train;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WaitingListManager {

    private static final int limit = 5;
    private static ConcurrentLinkedQueue<Ticket> ticketQueue;

    private TicketBooking booking;

    public WaitingListManager(TicketBooking booking) {
        this.booking = booking;
        ticketQueue = new ConcurrentLinkedQueue<>();
    }

    public boolean addToWaitingList(Ticket ticket){
        if (ticketQueue.size() >= limit)
            return false;
        ticketQueue.offer(ticket);
        return true;
    }


    public void processWaitingQueue(){
        Iterator<Ticket> iterator = ticketQueue.iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (booking.checkAvailability(ticket.getSource(), ticket.getDestination(), ticket.getNumberOfSeats())){
                booking.moveToBooking(ticket);
                System.out.println("Tickets confirmed for ticket id " + ticket.getId());
                iterator.remove();
            }
        }
    }
}
