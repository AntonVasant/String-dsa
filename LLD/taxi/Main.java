package LLD.taxi;

import java.util.Scanner;

public class Main {
    public static void main(String[] a){
        Repository repository = new Repository();
        Service service = new Service(repository);
        Controller controller = new Controller(service);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Enter 1 for book taxi \nEnter 2 for taxi history " +
                    "\nEnter 3 for adding taxi\nEnter 4 for quit\nEnter 5 for print all taxi\n6 for all his");
            int n = scanner.nextInt();
            switch (n){
                case 1:{
                    System.out.println("Enter start location");
                    char start = scanner.next().charAt(0);
                    System.out.println("Enter end location");
                    char end = scanner.next().charAt(0);
                    System.out.println("Enter time");
                    int time = scanner.nextInt();
                    controller.bookTaxi(start,end,time);
                    break;
                }
                case 2 :{
                    System.out.println("Enter taxi id");
                    int id = scanner.nextInt();
                    controller.printHistory(id);
                    break;
                }
                case  3:{
                    controller.addTaxi();
                    break;
                }
                case  4: {
                    flag = false;
                    break;
                }
                case 5:{
                    controller.printAllTaxi();
                }
                case 6:{
                    controller.printAllTaxiHis();
                }
            }
        }
    }
}
