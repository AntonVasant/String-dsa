package LLD.railway;

import java.util.Scanner;

public class Main {
    public static void main(String[] a){
        Repository repository = new Repository();
        Service service = new Service(repository);
        Controller controller = new Controller(service);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter 1 for booking \nEnter 2 for cancel \nEnter 3 for display\n Enter 4 for exit");
            int n = scanner.nextInt();
            switch (n){
                case 1:{
                    System.out.println("Enter name");
                    String name = scanner.next();
                    System.out.println("Enter age");
                    int age = scanner.nextInt();
                    System.out.println("Enter gender");
                    String gender = scanner.next();
                    System.out.println("Enter berth preference U/M/L");
                    char berth = scanner.next().charAt(0);
                    Passenger passenger = new Passenger(name,age,gender,berth);
                    controller.bookTicket(passenger);
                    break;
                }
                case 2: {

                }
                case  3: {
                    controller.printBookedTickets();
                    break;
                }
                case 4: {
                    break;
                }
            }
        }
    }
}
