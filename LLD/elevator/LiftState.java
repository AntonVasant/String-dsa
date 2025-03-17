package LLD.elevator;

public abstract class LiftState {

    Lift lift;

    public LiftState(Lift lift) {
        this.lift = lift;
    }

    abstract char getDirection();
    abstract void updateFloor();
    abstract void updateState();

    abstract int getTimeToReachFloor(int floor, char direction);
}
