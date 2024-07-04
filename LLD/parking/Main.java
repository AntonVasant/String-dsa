package LLD.parking;

import java.util.Scanner;

public class Main {
    public static void main(String a[]){
        Scanner scanner = new Scanner(System.in);
        Repository repository = new Repository();
        Service service = new Service(repository);
        Controller controller = new Controller(service);
        repository.addSpots();
        boolean flag = true;
        while (flag){
            System.out.println("Enter 1 to park");
            System.out.println("Enter 2 to unpark");
            System.out.println("Enter 3 to exit");
            int n = scanner.nextInt();
            switch (n){
                case 1: {
                    System.out.println("Enter number or the id of vehicle");
                    String number = scanner.next();
                    System.out.println("Enter Vehicle type");
                    System.out.println("1.BIKE");
                    System.out.println("2.CAR");
                    System.out.println("3.TRUCK");
                    VehicleType type = VehicleType.valueOf(scanner.next().toUpperCase());
                    controller.parkVehicle(number,type);
                    break;
                }
                case 2:{
                    flag = false;
                    break;
                }
                case 3:{
                    System.out.println("Enter id");
                    String id = scanner.next();
                    controller.unParkVehicle(id);
                }
                case 4:{
                    repository.details();
                }
            }
        }
    }
}
