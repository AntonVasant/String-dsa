package LLD.train;

public interface BookingStrategy {


    Ticket bookTicket(BookingRequest request, TicketInventory inventory, RACManager racManager);
}
