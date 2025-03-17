package LLD.taxi;

import javax.swing.event.ListDataEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private int id;
    private char currentLocation;
    private double totalEarnings;

    private List<Ride> rideList;

    public Taxi(int id){
        currentLocation = 'A';
        totalEarnings = 0;
        rideList = new ArrayList<>();
        this.id = id;
    }
    public void addRide(Ride  ride){
        totalEarnings += ride.getFare();
        rideList.add(ride);
    }

    public void printDetails(){
        if (!rideList.isEmpty()){
            System.out.println("Taxi id = "+id);
            for (Ride ride : rideList){
                System.out.println("Booking id "+ride.getBookingId());
                System.out.println("From "+ ride.getOnBoard() +" To "+ ride.getDestination() + " Fare Collected = "+ride.getFare());
            }
            System.out.println("Total Earning of the taxi is "+ totalEarnings);
            System.out.println("-----------------------------------------------------------");
        }

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation) {
        this.currentLocation = currentLocation;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(long totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public boolean isFree(int time) {
        if (!rideList.isEmpty()){
            LocalDateTime limit = LocalDateTime.now().plusHours(time);
            Ride ride = rideList.get(rideList.size()-1);
            int timeTaken = Math.abs(ride.getOnBoard() - ride.getDestination());
            LocalDateTime estimate = ride.getPickUpTime().plusHours(timeTaken);
            return limit.isAfter(estimate);
        }
        return true;
    }



    public List<Ride> getRideList() {
        return rideList;
    }

    public void setRideList(List<Ride> rideList) {
        this.rideList = rideList;
    }
}
