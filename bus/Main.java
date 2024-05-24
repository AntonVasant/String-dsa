package bus;

import java.util.Scanner;

public class Main {
    public static void main(String a[]){
        System.out.println("welcome");
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1. Display Available Seats\n" +
                    "2. Book a Seat\n" +
                    "3. Cancel a Booking\n" +
                    "4. View All Bookings\n" +
                    "5. Exit");
            int n = sc.nextInt();
            switch (n){
                case 1 :{
                    BookTicket.displaySeats();
                    break;
                }
                case 2:{
                    System.out.println("Enter your name");
                    String name = sc.next();
                    System.out.println("Enter your age");
                    int age = sc.nextInt();
                    System.out.println("Enter your seatNumber");
                    int seat = sc.nextInt();
                    BookTicket.bookTicket(new Passenger(age,seat,name));
                    break;
                }
                case 3:{
                    System.out.println("Enter the seat number");
                    int seat = sc.nextInt();
                    BookTicket.cancel(seat);
                    break;
                }
                case 4:{
                    BookTicket.displayBooking();
                    break;
                }
                case 5:{
                    break;
                }
            }
        }

    }
}
