package LLD.parking;

public class Vehicle {

    private String numberPlate;
    private VehicleType type;

    public Vehicle(String numberPlate,VehicleType type) {
        this.numberPlate = numberPlate;
        this.type  = type;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }
}
