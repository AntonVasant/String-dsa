package LLD.taxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        TaxiAllocation taxiAllocation = new NearestTaxiAllocationStrategy();
        System.out.println("Enter number of taxi");
        int num = scanner.nextInt();
        List<Taxi> taxis = initialize(num);
        BookingSystem bookingSystem = new BookingSystem(taxis, taxiAllocation);
        while (flag) {
            System.out.println("1.Book taxi\n2.View Details\n3.Quit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1 -> {
                    System.out.println("Enter pick up location");
                    char pickUp = scanner.next().charAt(0);
                    System.out.println("Enter drop location");
                    char drop = scanner.next().charAt(0);
                    System.out.println("Enter time");
                    int time = scanner.nextInt();
                    try {
                        Taxi taxi = bookingSystem.bookTaxi(pickUp, drop, time);
                        System.out.println("your taxi is with id "+taxi.getId());
                    }
                    catch (ClassNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    bookingSystem.printDetails();
                }
                case 3 -> flag = false;
            }

        }
    }

    private static List<Taxi> initialize(int number){
        List<Taxi> taxis = new ArrayList<>();
        for (int i = 0; i < number ; i++){
            Taxi taxi = new Taxi(i+1);
            taxis.add(taxi);
        }
        return taxis;
    }
}
