package LLD.railway;

import java.util.List;

public class Service {

    private Repository repository;
    private int berthLimit =  1;
    private int ticketIdGenerator = 1;

    private int RACLimit = 5;
    public Service(Repository repository) {
        this.repository = repository;
    }

    public Ticket bookTicket(Passenger passenger) {
        if (isBerthAvailable(passenger.getBerthPreference())){
            Ticket ticket = generateTicket(passenger,"berth",passenger.getBerthPreference());
            repository.addToConfirm(ticket);
            addToBerthSeatList(ticket);
            return ticket;
        }else if (isSeatAvailable(passenger) != '\0'){
            char c = isSeatAvailable(passenger);
            passenger.setBerthPreference(c);
            Ticket ticket = generateTicket(passenger,"berth",c);
            repository.addToConfirm(ticket);
            addToBerthSeatList(ticket);
            return ticket;
        } else if (isRacAvailable()) {
            Ticket ticket = generateTicket(passenger,"RAC",'\0');
            return ticket;
        }else addWaitingList(passenger);
        return null;
    }

    private Ticket generateTicket(Passenger passenger,String seatType,char berthType){
        Ticket ticket = new Ticket(passenger, seatType,berthType);
        ticket.setTicketId(ticketIdGenerator++);
        return ticket;
    }

    private void addWaitingList(Passenger passenger){
        repository.addWaiting(passenger);
    }

    private boolean isRacAvailable(){
        return repository.getQueueRAC().size() < RACLimit;
    }

    private char isSeatAvailable(Passenger passenger){
        if (repository.getLowerBerth().size() < berthLimit)
            return 'L';
        else if (repository.getMiddleBerth().size() < berthLimit) {
            return 'M';
        }else if (repository.getUpperBerth().size() < berthLimit)
            return 'U';
        return '\0';
    }

    private boolean isBerthAvailable(char c){

        if (c == 'U'){
            List<Ticket> tickets = repository.getUpperBerth();
            if (tickets.size() < berthLimit)
                return true;
        } else if (c == 'M') {
            List<Ticket> tickets = repository.getMiddleBerth();
            if (tickets.size() < berthLimit)
                return true;
        }else if(c == 'L'){
            List<Ticket> tickets = repository.getLowerBerth();
            if (tickets.size() < berthLimit) return true;
        }
        return false;
    }


    private void addToBerthSeatList(Ticket ticket){
        char c = ticket.getBerthType();
        if (c == 'U') Repository.upperBerth.add(ticket);
        else if (c == 'M') Repository.middleBerth.add(ticket);
        else Repository.lowerBerth.add(ticket);
    }
    public void printBookedSeats(){
       List<Ticket> tickets= repository.getConfirmedTicket();
       for (Ticket ticket : tickets){
           System.out.println("Passenger Name :"+ticket.getPassenger().getName());
           System.out.println("Passenger Age :"+ticket.getPassenger().getAge());
           System.out.println("Seat Type :"+ticket.getSeatType());
           System.out.println("gender :"+ticket.getPassenger().getGender());
           System.out.println("Berth Type :"+ticket.getBerthType());
       }
    }
}
