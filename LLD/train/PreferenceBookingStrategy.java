package LLD.train;

public class PreferenceBookingStrategy implements BookingStrategy{

    @Override
    public Ticket bookTicket(BookingRequest request, TicketInventory inventory, RACManager manager) {
        for (SeatType type : request.getPreference()){
            if (inventory.isSeatAvailable(type, request.getNumberOfSeats())){
                inventory.reduceSeat(type, request.getNumberOfSeats());
                return new Ticket(request.getUsername(),type,BookingStatus.CONFIRMED, request.getNumberOfSeats());
            }
        }

        if (manager.isAvailable(request.getNumberOfSeats())){
            manager.addToRacQueue(request);
            System.out.println("Added to waiting list");
            Ticket ticket = new Ticket();
            ticket.setStatus(BookingStatus.RAC);
            ticket.setUsername(request.getUsername());
            return ticket;
        }
        System.out.println("No tickets available");
        return null;
    }
}
