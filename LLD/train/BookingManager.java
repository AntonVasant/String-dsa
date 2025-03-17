package LLD.train;

public class BookingManager {

    private BookingStrategy strategy;
    private TicketInventory inventory;
    private RACManager racManager;

    public void setStrategy(BookingStrategy strategy){
        this.strategy = strategy;
    }

    public BookingManager(BookingStrategy strategy, TicketInventory inventory, RACManager racManager){
        this.strategy = strategy;
        this.inventory = inventory;
        this.racManager = racManager;
    }

    public Ticket bookTicket(BookingRequest request){
       return strategy.bookTicket(request,inventory, racManager);
    }



}
