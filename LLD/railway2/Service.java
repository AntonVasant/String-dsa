package LLD.railway2;

import java.util.List;

public class Service {
    private Repository repository;
    private static int idGen = 1;
    private static final int waitingListLimit = 10;
    private static final int RACLimit = 1;
    private static final int berthLimit = 1;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public Seat bookSeat(Passenger passenger){
        Seat seat = assignSeat(passenger);
        if (seat != null){
            passenger.setSeat(seat);
            repository.addConfirmList(passenger);
            return seat;
        }
        else if (isWaitingListAvailable()){
            repository.addWaiting(passenger);
            return new Seat(idGen++,"waiting");
        }
        return null;
    }

    public void cancelSeat(int seatId){
        Passenger passenger = repository.getPassengerById(seatId);
        if (passenger != null){
            moveRacToConfirm(passenger.getSeat());
            repository.removeFromConfirm(passenger);
            System.out.println("your ticket cancelled");
        }
    }

    public void printAll(){
        List<Passenger> list = repository.getAllConfirmList();
        String formatter = "%-15s%-15d%-15s%-15d%-15s";
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s","Name","Seat Id"," Seat Type ","Age","Gender");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");
        for (Passenger p : list){
            System.out.printf(formatter,p.getName(),p.getSeat().getSeatId(),p.getSeat().getSeatType(),p.getAge(),p.getGender());
            System.out.println();
        }
    }

    private Seat assignSeat(Passenger passenger){
        if (passenger.isCarryingChild() || passenger.getGender().equalsIgnoreCase("female") &&
                passenger.getAge() >= 60){
            if (repository.getLowerBerthCount() < berthLimit){
                Seat seat = new Seat(idGen++,"lower");
                repository.addLower(passenger);
                return seat;
            }
        }
        else if (isPreferredBerthAvailable(passenger.getPreferredBerth())){
            Seat seat = new Seat(idGen++, passenger.getPreferredBerth());
            addSeat(passenger);
            return seat;
        } else if (berthAvailable() != null) {
            Seat seat = new Seat(idGen++,berthAvailable());
            addSeat(passenger);
            return seat;
        } else if (isRacAvailable()) {
            Seat seat = new Seat(idGen++,"RAC");
            repository.addRAC(passenger);
            return seat;
        }
        return null;
    }
    private void addSeat(Passenger passenger){
        if (passenger.getPreferredBerth().equalsIgnoreCase("upper"))
            repository.addUpper(passenger);
        else if (passenger.getPreferredBerth().equalsIgnoreCase("lower")) {
            repository.addLower(passenger);
        } else if (passenger.getPreferredBerth().equalsIgnoreCase("middle")) {
            repository.addMiddle(passenger);
        }
    }
    private String berthAvailable(){
        if (repository.getUpperBerthCount() < berthLimit) return "upper";
        else if (repository.getLowerBerthCount() < berthLimit) return "lower";
        else if (repository.getMiddleBerthCount()  < berthLimit) return "middle";
        return null;
    }

    private boolean isPreferredBerthAvailable(String berth){
        if (berth.equalsIgnoreCase("lower"))
            return repository.getLowerBerthCount() < berthLimit;
        else if (berth.equalsIgnoreCase("middle"))
            return repository.getMiddleBerthCount() < berthLimit;
        else return repository.getUpperBerthCount() < berthLimit;
    }

    private void moveRacToConfirm(Seat seat){
        Passenger passenger = repository.moveRacToConfirm();
        if (passenger == null) return;
        passenger.getSeat().setSeatType(seat.getSeatType());
        passenger.getSeat().setSeatId(seat.getSeatId());
        addSeat(passenger);
        repository.addConfirmList(passenger);
        moveWaitingToRac(passenger);
    }

    private void moveWaitingToRac(Passenger passenger){
        if (passenger == null) return;
        Passenger passengers = repository.moveWaitingToRac();
        Seat seat = passenger.getSeat();
        passengers.setSeat(seat);
        repository.addRAC(passengers);
    }

    private boolean isRacAvailable(){
        return repository.racLimit() < RACLimit;
    }
    private boolean isWaitingListAvailable(){
        return repository.getWaitingList() < waitingListLimit;
    }
}
