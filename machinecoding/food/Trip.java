package machinecoding.food;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;

public class Trip {
    private static int idGen = 1;
    private int id;
    private List<Integer> customers;
    private double totalTip;
    private String deliveryExecutiveId;
    private char deliveryLocation;
    private char pickupLocation;
    private int[] deliveryTime;

    public Trip(String deliveryExecutiveId, char deliveryLocation, char pickupLocation) {
        id = idGen++;
        customers = new ArrayList<>();
        totalTip = 50;
        this.deliveryExecutiveId = deliveryExecutiveId;
        this.deliveryLocation = deliveryLocation;
        this.pickupLocation = pickupLocation;
    }

    public int getId() {
        return id;
    }

    public int[] getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int[] deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Integer> customers) {
        this.customers = customers;
    }



    public char getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(char deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public void addCustomerParcel(int customerId){
        customers.add(customerId);
        int size = customers.size();
        totalTip = 50 + (size - 1) * 5;
    }

    public boolean canCombineOrder(){
        return customers.size() <= 4;
    }
    public double getTotalTip() {
        return totalTip;
    }

    public void setTotalTip(double totalTip) {
        this.totalTip = totalTip;
    }

    public char getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(char pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
}
