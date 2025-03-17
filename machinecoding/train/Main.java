package machinecoding.train;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        TicketsRepository repository = new TicketsRepository(5,5);

        TicketBooking booking = new TicketBooking(repository);
        WaitingListManager waitingListManager = new WaitingListManager(booking);
        CancellingManager cancellingManager =  new CancellingManager(waitingListManager, repository);
        booking.setWaitingListManager(waitingListManager);
        PrepareChart prepareChart = new PrepareChart(repository);

        while (flag){
            System.out.println("1. Book ticket\n2. Cancel Ticket\n3. View chart");
            try {
                int choice = scanner.nextInt();
                switch (choice){
                    case 1 -> {
                        System.out.println("Enter source");
                        char source = scanner.next().charAt(0);
                        System.out.println("Enter destination");
                        char destination = scanner.next().charAt(0);
                        System.out.println("Enter number of seats");
                        int seats = scanner.nextInt();
                        booking.handleBooking(source, destination, seats);



                    }
                    case 2 -> {
                        System.out.println("Enter ticket id");
                        int id = scanner.nextInt();
                        System.out.println("Enter number of seats");
                        int seats = scanner.nextInt();
                        cancellingManager.processCancelRequest(id, seats);
                    }
                    case 3 -> prepareChart.displayChart();
                    case 4 -> flag = false;
                }
            }
            catch (InputMismatchException ime){
                System.out.println("Enter valid input");
                
            }

        }
    }
}
