package LLD.tax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends User{



    public Admin(String name, String password) {
        super(name, password);
    }

    private final TaxSystem system = TaxSystem.getInstance();

    @Override
    void display() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Enter 1 to set regime\nEnter 2 tot view details\nEnter 3 to edit\nEnter 4 to quit");
            int n = scanner.nextInt();
            switch (n){
                case 1 -> {
                    System.out.println("Enter regime new/old");
                    String s = scanner.next();
                    system.setTaxStrategy(s);
                }
                case 2 -> {
                    List<List<Integer>> list = TaxSystem.getTaxList();
                    for (List<Integer> list1 : list)
                        System.out.println(list1.get(0)+"    -     "+list1.get(1)+"%");
                }
                case  4 -> {
                    flag = false;
                }
            }
        }
    }

    @Override
    boolean login(String name, String password) {
       User user = system.getUserByName(name);
       return password.equals(user.getPassword());
    }
}
