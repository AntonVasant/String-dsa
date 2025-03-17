package machinecoding.food;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean state = true;
        List<DeliveryExecutive> executives = initializeAgents();
        FoodDeliverySystem system = new FoodDeliverySystem(new ConcreteSearch(), executives);
        Controller controller = new Controller(system);

        while (state){
            try {
                System.out.println("1. Order food\n2. View history\n3. View History Of Trip\n4. View History od Agent");
                int choice = scanner.nextInt();
                switch (choice){
                    case 1 -> {
                        System.out.println("Enter customer id");
                        int id = scanner.nextInt();
                        System.out.println("Enter Restaurant");
                        char r = scanner.next().charAt(0);
                        System.out.println("Enter delivery location");
                        char d = scanner.next().charAt(0);
                        System.out.println("Enter time");
                        String time = scanner.next();
                        controller.handleRequestForOrder(r,d,time,id);
                    }
                    case 5 -> state = false;
                }
            }
            catch (InputMismatchException ime){
                System.out.println("Enter valid details");
            }

        }
    }

    private static List<DeliveryExecutive> initializeAgents(){
        List<DeliveryExecutive> executives = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            DeliveryExecutive executive = new DeliveryExecutive("DE"+(i+1),0,0);
            executives.add(executive);
        }
        return executives;
    }


}
