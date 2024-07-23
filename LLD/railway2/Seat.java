package LLD.railway2;

public class Seat {
    private int seatId;
    private String seatType;

    public Seat(int seatId,String  seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getSeatId() {
        return seatId;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
}
