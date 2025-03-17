package LLD.train;

public class CancellingManager {

    private TicketInventory inventory;
    private RACManager racManager;

    public boolean cancelTicket(int ticketId){
        Ticket ticket = inventory.getTicket(ticketId);
        if (ticket != null){
            ticket.setStatus(BookingStatus.CANCELLED);
            inventory.addSeats(ticket.getType(),ticket.getSeats());
            racManager.moveToConfirmedStatus(ticket.getSeats());
            return true;
        }

        System.out.println("No Booking found");
        return false;
    }
}
