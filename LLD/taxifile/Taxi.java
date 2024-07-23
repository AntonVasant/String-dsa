package LLD.taxifile;

public class Taxi {
    private int id;
    private char currentLocation;
    private double amount;
    boolean isAvailable;

    public Taxi(int id) {
        this.amount =0;
        this.currentLocation = 'A';
        this.id = id;
        isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public char getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation) {
        this.currentLocation = currentLocation;
    }
}
