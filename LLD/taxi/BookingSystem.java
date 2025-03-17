package LLD.taxi;

import java.time.LocalDateTime;
import java.util.List;
import java.util.zip.DeflaterInputStream;

public class BookingSystem {

    private static List<Taxi> taxis;
    private static int idGen = 1;
    private TaxiAllocation taxiAllocation;

    public BookingSystem(List<Taxi> taxis, TaxiAllocation taxiAllocation){
        this.taxiAllocation = taxiAllocation;
        BookingSystem.taxis = taxis;
    }


    public Taxi bookTaxi(char from, char to, int time) throws ClassNotFoundException{
        Taxi taxi = taxiAllocation.findTaxi(taxis,from, to, time);
        if (taxi == null){
            throw new ClassNotFoundException("No taxi");
        }
        double fare = calculateFare(from, to);
        Ride ride = new Ride();
        ride.setPickUpTime(LocalDateTime.now().plusHours(Math.abs(taxi.getCurrentLocation() - from)));
        ride.setBookingId(idGen++);
        ride.setTaxiId(taxi.getId());
        ride.setOnBoard(from);
        ride.setDestination(to);
        ride.setFare(fare);
        taxi.addRide(ride);
        taxi.setCurrentLocation(to);
        return taxi;
    }

    private double calculateFare(char from , char to) {
        int distance = Math.abs(from - to);
        distance *= 15;
        if (distance <= 5) return 100;
        return (distance - 5) * 15 + 500;
    }

    public void printDetails(){
        for (Taxi taxi : taxis) {
            taxi.printDetails();
        }
    }
}
