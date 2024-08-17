package LLD.tax;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaxSystem system = TaxSystem.getInstance();
        FileHandling fileHandling = FileHandling.getInstance();
        fileHandling.loadData();
        boolean flag = true;
        while (flag){
            System.out.println("Enter 1 for customer \nEnter 2 for admin\nEnter 3 to exit");
            int n = scanner.nextInt();
            User loggedUser;
            if (n == 1 || n == 2){
                System.out.println("Enter name");
                String name = scanner.next();
                System.out.println("Enter password");
                String pass = scanner.next();
                User user =  system.getUserByName(name);
                if (user != null){
                   if ( user.login(name,pass)) {
                       loggedUser = user;
                       loggedUser.display();
                   }
                }
            }
            if (n == 3){
                flag = false;
            }
        }
    }
}
