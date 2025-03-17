package LLD.train;

import java.util.List;

public class BookingRequest {
    private String username;
    private List<SeatType> preference;
    private BookingStatus status;
    private int numberOfSeats;

    public BookingRequest(String username, List<SeatType> preference, BookingStatus status, int numberOfSeats) {
        this.username = username;
        this.preference = preference;
        this.status = status;
        this.numberOfSeats = numberOfSeats;
    }

    public String getUsername() {
        return username;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<SeatType> getPreference() {
        return preference;
    }

    public void setPreference(List<SeatType> preference) {
        this.preference = preference;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
