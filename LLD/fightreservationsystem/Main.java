package LLD.fightreservationsystem;

public class Main {
    public static void main(String a[]){
        Repository repository = new Repository();
        Service service = new Service(repository);
        FlightReservationController controller = new FlightReservationController(service);



    }
}
