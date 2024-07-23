package LLD.foodDelivery;

import java.sql.Time;
import java.time.LocalDateTime;

public class OrderPlaceRequest {
    private String location;
    private char destinationPoint;
    private LocalDateTime time;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public OrderPlaceRequest(char destinationPoint,String location) {
        this.destinationPoint = destinationPoint;
        this.location = location;
    }

    public char getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(char destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
