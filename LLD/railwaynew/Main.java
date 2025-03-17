package LLD.railwaynew;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketSystem system = TicketSystem.getInstance();
        boolean flag = true;
        while (flag){
            System.out.println("1. Book ticket\n2. Cancel\n3. View");
            int n = scanner.nextInt();
            switch (n){
                case 1 ->{
                    System.out.println("Enter source, destination and number of seats");
                    char s = scanner.next().charAt(0);
                    char d = scanner.next().charAt(0);
                    int num = scanner.nextInt();
                    TicketBooking ticketBooking = new TicketBooking(s,d,num);
                    ticketBooking.execute();;
                }
                case  2 -> {
                    System.out.println("Enter pnr and number of seats");
                    int p = scanner.nextInt();
                    int t = scanner.nextInt();
                    TicketCancelling cancelling = new TicketCancelling(p,t);
                    cancelling.execute();
                }
                case 3 -> system.displayTickets();
                case 4  ->
                    flag = false;
            }
        }
    }
}
