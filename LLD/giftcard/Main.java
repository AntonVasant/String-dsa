package LLD.giftcard;

import java.util.Scanner;

public class Main {
    public static void main(String[] a){
        Scanner scanner = new Scanner(System.in);
        Repository repository = new Repository();
        GiftCardFactory giftCardFactory = new GiftCardFactory();
        Service service = new Service(repository,giftCardFactory);
        Controller controller = new Controller(service);
        boolean flag = true;
        while (flag){
            System.out.println("Enter 1 for creating card\nEnter 2 for top up\n" +
                    "Enter 3 for purchase\nEnter 4 for display all transaction\nEnter 5 for creating customer\n" +
                    "Enter 6 to print all customer\nEnter 7 for quit");
            int n = scanner.nextInt();
            switch (n){
                case 1:{
                    System.out.println("Enter account number");
                    int number = scanner.nextInt();
                    System.out.println("Enter amount");
                    double amount = scanner.nextDouble();
                    controller.createGiftCard(number,amount);
                    break;
                }
                case 2:{
                    System.out.println("Enter your card no");
                    int card = scanner.nextInt();
                    System.out.println("Enter pin");
                    int pin = scanner.nextInt();
                    System.out.println("Enter amount");
                    double amount = scanner.nextDouble();
                    controller.topUp(pin,amount,card);
                }
                case  3:{
                    System.out.println("Enter your id");
                    int id = scanner.nextInt();
                    System.out.println("Enter amount");
                    double amount = scanner.nextDouble();
                    System.out.println("Enter pin");
                    int pin = scanner.nextInt();
                    controller.purchase(id,amount,pin);
                    break;
                }
                case 5:{
                    System.out.println("Enter name");
                    String name  = scanner.next();
                    controller.createCustomer(name);
                    break;
                }
                case 6:{
                    controller.printAllCustomer();
                }
                case  7:{
                    flag = false;
                    scanner.close();
                    break;
                }
            }
        }
    }
}
