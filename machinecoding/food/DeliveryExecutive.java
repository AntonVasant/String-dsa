package machinecoding.food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeliveryExecutive {

    private String id;
    private char currentLocation;
    private int[] lastPickUpTime;
    private double totalAllowance;
    private double totalEarnings;
    private List<Trip> tripList;

    public DeliveryExecutive(String id, double totalAllowance, double totalEarnings) {
        this.id = id;
        this.currentLocation = 'A';
        this.totalAllowance = totalAllowance;
        this.totalEarnings = totalEarnings;
        this.tripList = new ArrayList<>();
    }

    public int[] getLastPickUpTime() {
        return lastPickUpTime;
    }

    public void setLastPickUpTime(int[] lastPickUpTime) {
        this.lastPickUpTime = lastPickUpTime;
    }

    public String getId() {
        return id;
    }

    public boolean canIncludeOrder(int[] time) {
        if (lastPickUpTime == null) return false;
        if (time[0] == lastPickUpTime[0])
            return time[1] - lastPickUpTime[1] <= 15;
        if (time[0] - lastPickUpTime[0] >= 2) return true;
        int leftOver = 60 - lastPickUpTime[1];
        return leftOver + time[1] <= 15;
    }

    public boolean isSameLocation(char c) {
        return currentLocation == c;
    }

    public void addAllowance(double money) {
        totalAllowance += money;
    }


    public char getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation) {
        this.currentLocation = currentLocation;
    }


    public double getTotalAllowance() {
        return totalAllowance;
    }

    public void setTotalAllowance(double totalAllowance) {
        this.totalAllowance = totalAllowance;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }


    public void addTrip(Trip trip) {
        totalEarnings += 50;
        addAllowance(10);
        tripList.add(trip);
    }

    private double getTotal(){
        double total = 0;
        for (Trip trip : tripList)
            total += trip.getTotalTip();
        return total;
    }

    public Trip getLastTrip() {
        return tripList.get(tripList.size() - 1);
    }


    public void printExecutiveTrips() {

    }

    public void printDetailsOfAgent() {
        System.out.printf("%-20s%.2f", id, getTotal());
    }
}
