package LLD.taxi;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private int taxid;
    private char currentLocation;
    private int totalEarnings;
    private boolean isAvailable;
    private int availableTime;
    List<TaxiHistory> taxiHistories;

    Taxi(int taxid){
        this.taxid = taxid;
        this.currentLocation = 'A';
        this.totalEarnings = 0;
        this.isAvailable = true;
        this.availableTime = 0;
        this.taxiHistories = new ArrayList<>();
    }

    public int getTaxid() {
        return taxid;
    }

    public void setTaxid(int taxid) {
        this.taxid = taxid;
    }

    public List<TaxiHistory> getTaxiHistories() {
        return taxiHistories;
    }

    public void setTaxiHistories(List<TaxiHistory> taxiHistories) {
        this.taxiHistories = taxiHistories;
    }

    public int getAvailableTime()
    {
        return availableTime;
    }

    public boolean isAvailable() {

        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setAvailableTime(int availableTime) {
        this.availableTime = availableTime;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(int totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public char getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation) {
        this.currentLocation = currentLocation;
    }


}
