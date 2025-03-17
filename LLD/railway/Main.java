package LLD.railway;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter points");
        int point = scanner.nextInt();
        System.out.println("Enter seats");
        int seats = scanner.nextInt();
        Repository repository = new Repository(seats, point);
        BookingService bookingService = new BookingService(repository);
        CancellingService cancellingService = new CancellingService(repository);
        PrepareChart prepareChart = new PrepareChart(repository);
        boolean status = true;
        while (status) {
            System.out.println("1. Book seat\n2. Cancel seat\n3. Show stats");
            int choice = scanner.nextInt();
            switch (choice){
                case 1 -> {
                    System.out.println("Enter source");
                    char source = scanner.next().charAt(0);
                    System.out.println("Enter destination");
                    char destination = scanner.next().charAt(0);
                    System.out.println("Seats");
                    int seat = scanner.nextInt();
                    BookingRequest bookingRequest = new BookingRequest(source, destination, seat);
                    Booking booking = bookingService.handleBookingRequest(bookingRequest);
                   if (booking != null) {
                       System.out.println("Booking success your id "+ booking.getBookingId() + " Seats booked ="+booking.getNumberOfSeats());
                   }
                }
                case 2 ->{
                    System.out.println("Enter booking id");
                    int bookingId = scanner.nextInt();
                    System.out.println("Seats to cancel");
                    int seatsToCancel = scanner.nextInt();
                    cancellingService.cancelSeats(bookingId, seatsToCancel);
                }
                case 3 -> prepareChart.displayTickets();
                case 4 -> status = false;
            }
        }
    }
}
