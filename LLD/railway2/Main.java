package LLD.railway2;

import java.util.Scanner;

public class Main {

    public static void main(String[] a){
        boolean flag = true;
        Repository repository = new Repository();
        Service service  = new Service(repository);
        Controller controller = new Controller(service);
        Scanner scanner = new Scanner(System.in);
        while (flag){
            System.out.println("Enter 1 to book ticket\nEnter 2 for printing all booked tickets\nEnter 3 for cancelling ticket");
            int n = scanner.nextInt();
            switch (n){
                case 1:{
                    System.out.println("Enter name");
                    String name = scanner.next();
                    System.out.println("Enter gender");
                    String gender = scanner.next();
                    System.out.println("Enter berth preference");
                    String berth = scanner.next();
                    System.out.println("Enter Age");
                    int age = scanner.nextInt();
                    System.out.println("Are you carrying child  yes/no");
                    String isChild = scanner.next();
                    boolean child = false;
                    if (isChild.equalsIgnoreCase("yes")) child = true;
                    Passenger passenger = new Passenger(name,gender,age,child,berth);
                    controller.bookSeat(passenger);
                    break;
                }
                case 2:{
                    controller.printAllBooked();
                    break;
                }
                case 3:{
                    System.out.println("Enter your seat id");
                    int id = scanner.nextInt();
                    controller.cancelSeat(id);
                }
            }
        }
    }
}
