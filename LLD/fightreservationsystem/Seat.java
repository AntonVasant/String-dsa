package LLD.fightreservationsystem;

import string.StrStr;

public class Seat {

    private String seatId;
    private Flight flight;
    private SeatType seatType;

    private boolean isAvailable;

    public Seat(Flight flight) {
        this.flight = flight;
    }

    public Seat(String s, boolean b) {
        seatId = s;
        isAvailable = b;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }
}
