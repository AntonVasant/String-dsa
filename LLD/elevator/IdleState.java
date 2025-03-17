package LLD.elevator;

public class IdleState extends LiftState{
    public IdleState(Lift lift) {
        super(lift);
    }

    @Override
    char getDirection() {
        return 'I';
    }

    @Override
    void updateFloor() {

    }

    @Override
    void updateState() {

    }

    @Override
    int getTimeToReachFloor(int floor, char direction) {
        return Math.abs(floor - lift.getCurrentFloor());
    }
}
