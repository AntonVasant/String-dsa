package LLD.zohogiiftcard;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        Service service = new Service(repository);
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(service,scanner);
        boolean flag = true;

        while (flag){
            System.out.println("Enter 1 login\nEnter 2 for purchase\nEnter 3 to quit");
            int n = scanner.nextInt();
            switch (n){
                case 1 -> {
                    System.out.println("Enter your password");
                    String password = scanner.next();
                    System.out.println("Enter your id");
                    int id = scanner.nextInt();
                    boolean res = controller.login(id,password);
                    if (res){
                        boolean f = true;
                        while (f){
                            System.out.println("Enter 1 for creating new card\nEnter 2 for top up\nEnter 3 for printing transaction" +
                                    "\nEnter 4 for blocking card\nEnter 5 for log out");
                            int choice = scanner.nextInt();
                            switch (choice){
                                case 1 -> {
                                    System.out.println("Enter id");
                                    int cusId = scanner.nextInt();
                                    System.out.println("Enter amount");
                                    double amount = scanner.nextDouble();
                                    controller.createCard(cusId,amount);
                                }
                                case 2-> {
                                    System.out.println("Enter id");
                                    int cusId = scanner.nextInt();
                                    System.out.println("Enter amount");
                                    double amount = scanner.nextDouble();
                                    System.out.println("Enter card id");
                                    int card = scanner.nextInt();
                                    controller.topUp(cusId,amount,card);
                                }
                                case 3 -> controller.printAll();
                                case 4 -> {
                                    System.out.println("Enter id");
                                    int num = scanner.nextInt();
                                    System.out.println("Enter card number");
                                    int card = scanner.nextInt();
                                    controller.blockCard(num,card);
                                }
                                case  5 -> f = false;
                            }
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Enter id");
                    int id = scanner.nextInt();
                    System.out.println("Enter amount");
                    double amount = scanner.nextDouble();
                    System.out.println("Enter cars password");
                    int password = scanner.nextInt();
                    controller.purchase(id,amount,password);
                }
                case 3 -> flag = false;
            }
        }
    }
}
