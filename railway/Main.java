package railway;

import java.util.Scanner;

public class Main {
    public static void main(String a[]) {
        boolean loop = true;
        while (loop) {
            System.out.println("Enter the option below\n1.Book Ticket\n2.Cancel Ticket\n" +
                    "3.Display Waiting list\n4.Display RAC list\n5.Exit");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    System.out.println("Enter your name");
                    String name = sc.next();
                    System.out.println("Enter age");
                    int age = sc.nextInt();
                    System.out.println("Enter seat preference");
                    String c = sc.next();
                    Passengers p = new Passengers(name,age,c);
                    TicketBooking.bookTicket(p);
                    break;
                }
                case 2 : {
                    System.out.println("Enter your seat id");
                    int id= sc.nextInt();
                    TicketCancelling.cancel(id);
                    break;
                }
                case 3 :{
                    TicketBooking.displayWaiting();
                    break;
                }
                case 4 :{
                    TicketBooking.displayRAC();
                    break;
                }
                case 5 :{
                    loop=false;
                }
            }
        }
    }
}
