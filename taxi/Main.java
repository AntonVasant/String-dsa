package taxi;

import java.util.Scanner;

public class Main {
    public static void main(String a[])throws CloneNotSupportedException{
        boolean loop = true;
        while(loop){
            System.out.println("Choose One of below \nBook Taxi\nShow Details\nExit");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            switch (n){
                case 1:{
                    System.out.println("Enter pick up location");
                    char pickLocation = scanner.next().charAt(0);
                    System.out.println("Enter drop location");
                    char dropLocation = scanner.next().charAt(0);
                    System.out.println("Enter pickup time");
                    int pickTime = scanner.nextInt();
                    System.out.println(TaxiBooking.booking(pickLocation,dropLocation,pickTime));
                    break;
                }
                case 2:{
                    TaxiBooking.display();
                    break;
                }
                case 3 :{
                    loop=false;
                    break;
                }
            }
        }
    }
}
