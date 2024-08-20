package LLD.tollcollecting;

public abstract class Toll {

    private char location;
    private int tollId;

    public void setLocation(char location) {
        this.location = location;
    }

    public void setTollId(int tollId) {
        this.tollId = tollId;
    }

    public Toll(char location, int tollId) {
        this.location = location;
        this.tollId = tollId;
    }

    public char getLocation() {
        return location;
    }

    public int getTollId() {
        return tollId;
    }

    abstract double calculateToll(String vehicle);
}
