package taxi;
public class Taxi implements Cloneable{

    private char currentLocation='A';
    private int customerId;
    private int taxiId;
    private int pickUpLocation;
    private int dropLocation;
    private int earnings;
    private int pickUpTime;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    private int dropTime;
    public char getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getTaxiId() {
        return taxiId;
    }

    public int getPickUpTime() {
        return pickUpTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public void setPickUpTime(int pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public int getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(int dropLocation) {
        this.dropLocation = dropLocation;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public int getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(int pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "currentLocation=" + currentLocation +
                ", customerId=" + customerId +
                ", taxiId=" + taxiId +
                ", pickUpLocation=" + pickUpLocation +
                ", dropLocation=" + dropLocation +
                ", earnings=" + earnings +
                ", pickUpTime=" + pickUpTime +
                ", dropTime=" + dropTime +
                '}';
    }
}
