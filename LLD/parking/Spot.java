package LLD.parking;

public class Spot {
    private String spotId;
    private  boolean isAvailable;
    private SpotType type;

    public Spot(String spotId,boolean isAvailable,SpotType type) {
        this.spotId = spotId;
        this.isAvailable = isAvailable;
        this.type = type;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public SpotType getType() {
        return type;
    }

    public void setType(SpotType type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
