package LLD.atm;

import LLD.atm.exception.AccountNotFoundException;

import java.util.Scanner;

public class Main {
    public static void main(String[] a) throws AccountNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ATMRepository repository = new ATMRepository();
        ATMService service = new ATMService(repository);
        Controller controller = new Controller(service);
        boolean flag = true;
        while (flag){
            System.out.println("Enter 1 to create account\nEnter 2 to deposit money");
            int n = scanner.nextInt();
            switch (n){
                case 1:{
                    System.out.println("Enter Name");
                    String name = scanner.next();
                    controller.createAccount(name);
                    break;
                }
                case 2:{
                    System.out.println("Enter amount");
                    double amount = scanner.nextDouble();
                    System.out.println("Enter card");
                    String card = scanner.next();
                    System.out.println("Enter your id");
                    int id = scanner.nextInt();
                    controller.deposit(amount,card,id);
                }
            }
        }
    }
}
