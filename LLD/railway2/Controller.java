package LLD.railway2;

public class Controller {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void bookSeat(Passenger passenger){
        Seat seat = service.bookSeat(passenger);
        if (seat == null)
            System.out.println("no available place in train");
        else System.out.println("your seat id "+seat.getSeatId()+ " seat type "+seat.getSeatType());
    }

    public void printAllBooked(){
        service.printAll();
    }
    public void cancelSeat(int id){
        service.cancelSeat(id);
    }
}
