package LLD.elevator;

public class MovingUpState extends LiftState{

    public MovingUpState(Lift lift) {
        super(lift);
    }



    @Override
    int getTimeToReachFloor(int floor, char direction) {
        int maxFloor = getMaxFloor();
        boolean hasStopsInOppositeDirection = lift.hasRequestInOppositeDirection();
        if (floor > maxFloor && hasStopsInOppositeDirection)
            return -1;
        if (direction == 'U'){
            if (floor < lift.getCurrentFloor()) return -1;
            if (floor == lift.getCurrentFloor()) return 0;
            return floor - lift.getCurrentFloor();
        }
        return floor - lift.getCurrentFloor();
    }


    @Override
    char getDirection() {
        return 'U';
    }

    @Override
    void updateFloor() {
        int max = getMaxFloor();
        if (lift.getCurrentFloor() < max)
            lift.setCurrentFloor(lift.getCurrentFloor() + 1);
    }

    @Override
    void updateState() {
        if (lift.getCurrentFloor() >= getMaxFloor())
            lift.setState('D');

    }

    private int getMaxFloor(){
        int floor = -1;
        for (LiftRequest request : lift.getRequests()){
            if (request.getDestination() > floor)
                floor = request.getDestination();
            if (request.getSource() > floor)
                floor = request.getSource();
        }
        return floor;
    }
}
