package LLD.foodDelivery;

public class DeliveryAllotment {

    private int amountEarned;
    private String location;
    private int executiveId;

    public DeliveryAllotment(int amountEarned,String location) {
        this.amountEarned = amountEarned;
        this.location = location;
    }

    public int getAmountEarned() {
        return amountEarned;
    }

    public void setAmountEarned(int amountEarned) {
        this.amountEarned = amountEarned;
    }

    public String getLocation() {
        return location;
    }

    public int getExecutiveId() {
        return executiveId;
    }

    public void setExecutiveId(int executiveId) {
        this.executiveId = executiveId;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
