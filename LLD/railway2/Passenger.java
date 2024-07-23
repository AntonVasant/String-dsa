package LLD.railway2;

public class Passenger {
    private Seat seat;
    private String name;
    private int age;
    private String gender;
    private boolean carryingChild;
    private String preferredBerth;

    public Passenger(String name,String gender,int age,boolean carryingChild,String preferredBerth) {
        this.age = age;
        this.name = name;
        this.carryingChild = carryingChild;
        this.gender = gender;
        this.preferredBerth = preferredBerth;
    }

    public boolean isCarryingChild() {
        return carryingChild;
    }

    public String getPreferredBerth() {
        return preferredBerth;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
