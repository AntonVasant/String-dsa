package LLD.taxi;

import java.time.LocalDateTime;

public class Ride {
    private  int bookingId;
    private int taxiId;
    private char onBoard;
    private char destination;
    private double fare;
    private LocalDateTime pickUpTime;

    public LocalDateTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalDateTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public char getOnBoard() {
        return onBoard;
    }

    public void setOnBoard(char onBoard) {
        this.onBoard = onBoard;
    }

    public char getDestination() {
        return destination;
    }

    public void setDestination(char destination) {
        this.destination = destination;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
