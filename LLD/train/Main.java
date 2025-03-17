package LLD.train;

public class Main {
    public static void main(String[] args) {

        RACManager racManager = new RACManager(5);
        TicketInventory inventory = new TicketInventory();
        BookingStrategy strategy = new PreferenceBookingStrategy();
        BookingManager bookingManager = new BookingManager(strategy, inventory, racManager);
    }
}
