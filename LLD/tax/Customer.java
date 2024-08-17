package LLD.tax;

import java.util.Scanner;

public class Customer extends User{
    public Customer(String name, String password) {
        super(name, password);
    }

    private final TaxSystem taxSystem = TaxSystem.getInstance();

    @Override
    void display() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\tOptions");
        System.out.println("Enter 1 to Create account\nEnter 2 to submit tax\nEnter 3 to exit");
        int n = scanner.nextInt();
        boolean flag = true;
        while (flag){
            switch (n){
                case 1 -> {
                    System.out.println("Enter name");
                    String name = scanner.next();
                    System.out.println("Enter password");
                    String pass = scanner.next();
                    System.out.println("Enter type");
                    String type = scanner.next();
                    User user = AccountCreationFactory.createUser(type,name,pass);
                    taxSystem.saveUser(name,user);
                }
                case 2 -> {
                    System.out.println("Enter income");
                    double income = scanner.nextDouble();
                    System.out.println("Enter rent");
                    double house = scanner.nextDouble();
                    System.out.println("Enter travel");
                    double travel = scanner.nextDouble();
                    System.out.println("Enter investment");
                    double investment = scanner.nextDouble();
                    System.out.println("Enter pension");
                    double pension = scanner.nextDouble();
                    double tax = taxSystem.calculateTax(income,house,travel,investment,pension);
                    System.out.println("your tax "+tax);

                }
                case  3 -> {
                    System.out.println("Thank you");
                    flag = false;
                }
            }
        }
    }

    @Override
    boolean login(String name, String password) {
        User user = taxSystem.getUserByName(name);
        return user.getPassword().equals(password);
    }

}
