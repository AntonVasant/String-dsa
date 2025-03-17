package machinecoding.train;

public class CancellingManager {

    private WaitingListManager waitingListManager;
    private TicketsRepository repository;

    public CancellingManager(WaitingListManager waitingListManager, TicketsRepository repository) {
        this.waitingListManager = waitingListManager;
        this.repository = repository;
    }

    public boolean processCancelRequest(int ticketId, int numberOfSeats){
        Ticket ticket = repository.getTicketById(ticketId);
        if (ticket == null){
            System.out.println("Ticket not exist with the id");
            return false;
        }
        repository.cancelSeats(ticket.getSource(), ticket.getDestination(), numberOfSeats);
        if (numberOfSeats < ticket.getNumberOfSeats()){
            ticket.setStatus(Status.CANCELLED);

        }
        else{
            ticket.setNumberOfSeats(ticket.getNumberOfSeats() - numberOfSeats);
            repository.removeTicket(ticketId);
        }

        waitingListManager.processWaitingQueue();
        return true;
    }


}
