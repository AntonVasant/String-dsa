package LLD.taxifile;


import java.util.Scanner;

public class Main {

    public static void main(String[] a){

        String path = "C:\\Users\\Hp\\Desktop\\String\\LLD\\taxifile\\data";
        Repository repository = new Repository();
        Service service  = new Service(repository);
        Controller controller = new Controller(service);
        controller.loadData(path);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Enter 1 to add taxi\nEnter 2 to book taxi\nEnter 3 to display");
            int n = scanner.nextInt();
            switch (n){
                case 1:{
                    System.out.println("Enter taxi id");
                    int id = scanner.nextInt();
                    controller.createTaxi(id);
                    break;
                }
                case 2:{
                    System.out.println("Enter start location");
                    char start = scanner.next().charAt(0);
                    System.out.println("Enter end location");
                    char end = scanner.next().charAt(0);
                    System.out.println("Enter card number");
                    String card = scanner.next();
                    controller.bookTax(start,end,card);
                    break;
                }
                case 3:{
                    controller.printAll();
                }
            }
        }
    }
}
