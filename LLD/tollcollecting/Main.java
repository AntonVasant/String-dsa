package LLD.tollcollecting;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Repository repository = new Repository();
        DistanceService distanceService = new DistanceService(repository);
        Service service = new Service(repository,distanceService);
        Controller controller = new Controller(service);
        boolean flag = true;
        while (flag){
            System.out.println("Enter 1 to calculate toll\nEnter 2 for display details\nEnter 3 for quit");
            int n = scanner.nextInt();
            switch (n){
                case 1 -> {
                    System.out.println("Enter start");
                    char start = scanner.next().charAt(0);
                    System.out.println("Enter end");
                    char end = scanner.next().charAt(0);
                    System.out.println("Enter Type");
                    String type = scanner.next();
                    controller.calculateToll(start,end,type);
                }
                case 2 ->{

                }case 3 -> flag = false;
            }
        }
    }
}
