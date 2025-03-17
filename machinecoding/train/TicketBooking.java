package machinecoding.train;

public class TicketBooking {
    private static final int seatLimit = 5;
    private TicketsRepository repository;
    private WaitingListManager waitingListManager;

    public TicketBooking(TicketsRepository repository){
        this.repository = repository;
    }

    public void moveToBooking(Ticket ticket){
        repository.lowerSeats(ticket.getSource(), ticket.getDestination(), ticket.getNumberOfSeats());
        repository.addTicket(ticket.getId(), ticket);
        ticket.setStatus(Status.BOOKED);

    }

    public boolean handleBooking(char source, char destination, int seats){
        Ticket ticket = new Ticket(seats, source, destination);
        if (!checkAvailability(source, destination, seats)){
            if (addToWaitingList(ticket))
                System.out.println("added to waiting");
            return false;
        }
        moveToBooking(ticket);
        System.out.println("Ticket booked id "+ ticket.getId());
        return true;
    }

    private boolean addToWaitingList(Ticket ticket){
        return waitingListManager.addToWaitingList(ticket);
    }


    public boolean checkAvailability(char source, char destination, int seats){
        int[] totalSeats = repository.getSeatsPerStops();
        for (int i = source - 'A'; i <= destination - 'A'; i++){
            if (totalSeats[i] + seats > seatLimit)
                return false;
        }
        return true;
    }

    public void setWaitingListManager(WaitingListManager manager){
        waitingListManager = manager;
    }
}
