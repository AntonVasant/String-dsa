package LLD.train;

public class OldAgeBookingStrategy implements BookingStrategy{
    @Override
    public Ticket bookTicket(BookingRequest request, TicketInventory inventory, RACManager racManager) {
        if (inventory.isSeatAvailable(SeatType.LOWER, request.getNumberOfSeats())){
            inventory.reduceSeat(SeatType.LOWER, request.getNumberOfSeats());
            return new Ticket(request.getUsername(),SeatType.LOWER, BookingStatus.CONFIRMED, request.getNumberOfSeats());
        }
        System.out.println("No tickets available");
        return null;
    }
}
