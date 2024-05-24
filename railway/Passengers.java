package railway;

public class Passengers {
    static int idGenerator=0;
    private int passengerId=0;
    private String name;
    private int age;
    private String seatPreference;
    private int seatId;
    private String seatType;
    public Passengers(String name,int age,String seatPreference) {
        this.name = name;
        this.age=age;
        this.seatPreference=seatPreference;
        this.passengerId=++idGenerator;
        this.seatId+=1;
    }

    public String getSeatType() {
        return seatType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getSeatPreference() {
        return seatPreference;
    }

    public void setSeatPreference(String seatPreference) {
        this.seatPreference = seatPreference;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
}
