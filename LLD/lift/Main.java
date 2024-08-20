package LLD.lift;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        Service service = new Service(repository);
        Controller controller = new Controller(service);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Enter 1 for request\nEnter 2 to view position\nEnter 3 to quit");
            int n = scanner.nextInt();
            switch (n){
                case  1 -> {
                    System.out.println("Enter source");
                    int source= scanner.nextInt();
                    System.out.println("Enter destination");
                    int destination= scanner.nextInt();
                    System.out.println("Enter people");
                    int people = scanner.nextInt();
                    controller.assignLift(source,destination,people);
                }
                case  2-> controller.printPosition();
                case  3 -> flag = false;
            }
        }
    }
}
