package LLD.fightreservationsystem;

import java.util.Scanner;

public class Main {
    public static void main(String a[]){
        Repository repository = new Repository();
        Service service = new Service(repository);
        FlightReservationController controller = new FlightReservationController(service);
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag){
            System.out.println("Enter 1 for create user\nEnter 2 for booking\nEnter 3 for cancel\nEnter 4 for exit");
            int n = scanner.nextInt();
            switch (n){
                case 1:{
                    System.out.println("Enter name");
                    String name = scanner.next();
                    System.out.println("Enter email");
                    String mail = scanner.next();
                    controller.creatUser(name,mail);
                    break;
                }
                case  2:{
                    System.out.println("Enter user id");
                    String id = scanner.next();
                    System.out.println("Enter flight id");
                    String flight = scanner.next();
                    System.out.println("Enter seat type");
                    String type= scanner.next();
                    SeatType seatType;
                    if (type.equalsIgnoreCase("econimc"))
                        seatType = SeatType.ECONOMY;
                    else if (type.equalsIgnoreCase("Business")) {
                        seatType = SeatType.BUSINESS_CLASS;
                    }
                    else seatType = SeatType.MIDDLE;
                    controller.bookTicket(id,flight,seatType);
                    break;
                }
            }
        }


    }
}
