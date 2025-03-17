package LLD.elevator;

public class MovingDownState extends LiftState{

    public MovingDownState(Lift lift) {
        super(lift);
    }

    @Override
    char getDirection() {
        return 'D';
    }

    public int getTimeToReachFloor(int floor, char direction){
        int minFloor = getMinFloor();
        boolean  hasStopsInOppositeDir = lift.hasRequestInOppositeDirection();
        if (floor < minFloor && hasStopsInOppositeDir)
            return -1;
        if (direction == getDirection()){
            if (floor > lift.getCurrentFloor()) return -1;
            if (floor == lift.getCurrentFloor()) return 0;
            return lift.getCurrentFloor() - floor;
        }
        return lift.getCurrentFloor() - floor;
    }

    private int getMinFloor(){
        int floor = Integer.MAX_VALUE;
        for (LiftRequest request : lift.getRequests()){
            if (request.getSource() < floor)
                floor = request.getSource();
            if (request.getDestination() < floor)
                floor = request.getDestination();
        }
        return floor;
    }

    @Override
    void updateFloor() {
        if (lift.getCurrentFloor() > getMinFloor()){
            lift.setCurrentFloor(lift.getCurrentFloor() - 1);
        }
    }

    @Override
    void updateState() {
        if (lift.getCurrentFloor() <= getMinFloor())
            lift.setState('U');
    }
}
