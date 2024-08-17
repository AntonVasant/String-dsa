package LLD.tollsystem;

public abstract class Toll {
    private char point;
    private String name;
    private double totalMoney;

    abstract double calculateToll(Vehicle vehicle);
}
