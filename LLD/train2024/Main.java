package LLD.train2024;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        TicketBookingSystem system = TicketBookingSystem.getInstance();
        while (flag){
            System.out.println("Enter 1 for booking \nEnter 2 for cancellation\nEnter 3 for chart");
            int n = scanner.nextInt();
            switch (n){
                case 1 ->{
                    System.out.println("Enter source");
                    char source = scanner.next().charAt(0);
                    System.out.println("Enter destination");
                    char destination = scanner.next().charAt(0);
                    System.out.println("Enter seats");
                    int seats = scanner.nextInt();
                    TicketBooking booking = new TicketBooking(source,destination,seats);
                    booking.execute();
                }
                case 2 ->{
                    System.out.println("Enter pnr");
                    int pnr = scanner.nextInt();
                    System.out.println("Enter number of seats");
                    int seats = scanner.nextInt();
                    TicketCancelling cancelling = new TicketCancelling(pnr,seats);
                    cancelling.execute();
                }
                case 3 -> system.displayChart();
                case 4-> flag= false;
            }
        }
    }
}
