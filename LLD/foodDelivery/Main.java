package LLD.foodDelivery;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] a){
        Repository repository = new Repository();
        Service service = new Service(repository);
        Controller controller = new Controller(service);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Enter 1 for order\nEnter 2 for list\nEnter 3 for quit");
            int n = scanner.nextInt();
            switch (n){
                case 1:{
                    System.out.println("Enter the location");
                    String location = scanner.next();
                    System.out.println("Enter des location");
                    char des = scanner.next().charAt(0);
                    OrderPlaceRequest request = new OrderPlaceRequest(des,location);
                    controller.placeOrder(request);
                }
            }
        }
    }
}
