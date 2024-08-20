package LLD.lift;

public class Lift {
    private int liftId;
    private int currentFloor;
    private int source;
    private int destination;
    private int totalCapacity;
    private int highestFloor;
    private int lowestFloor;
    private  LiftStatus status;
    private int currentPeople;

    public int getCurrentPeople() {
        return currentPeople;
    }

    public void setCurrentPeople(int currentPeople) {
        this.currentPeople = currentPeople;
    }

    public int getLiftId() {
        return liftId;
    }

    public void setLiftId(int liftId) {
        this.liftId = liftId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Lift(int liftId, int currentFloor, int source, int destination, int totalCapacity, int highestFloor, int lowestFloor,LiftStatus status) {
        this.liftId = liftId;
        this.currentFloor = currentFloor;
        this.source = source;
        this.destination = destination;
        this.totalCapacity = totalCapacity;
        this.highestFloor = highestFloor;
        this.lowestFloor = lowestFloor;
        this.status = status;
        currentPeople = 0;
    }
    public boolean isValid(int source,int destination,int people){
        int high = Math.max(source,destination);
        int low = Math.min(source,destination);
        if (highestFloor < high || low < lowestFloor || totalCapacity < currentPeople + people) return false;
        return true;
    }
    public int getHighestFloor() {
        return highestFloor;
    }
    public boolean isSameDirection(int source,int destination){
        return  currentFloor < destination == source < destination;
    }
    public int getDistance(int floor){
        return Math.abs(currentFloor - floor);
    }

    public void setHighestFloor(int highestFloor) {
        this.highestFloor = highestFloor;
    }

    public int getLowestFloor() {
        return lowestFloor;
    }

    public void setLowestFloor(int lowestFloor) {
        this.lowestFloor = lowestFloor;
    }

    public LiftStatus getStatus() {
        return status;
    }

    public void setStatus(LiftStatus status) {
        this.status = status;
    }

    public boolean isAvailable(){
        return this.status != LiftStatus.MAINTAINENCE;
    }




}
