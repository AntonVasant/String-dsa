package LLD.elevator;

import java.util.ArrayList;
import java.util.List;

public class Lift {

    private static List<LiftRequest> requests;

    private LiftState currentState;
    private LiftState movingUpState;
    private LiftState  movingDownState;
    private LiftState idleState;
    private int currentFloor;

    public Lift(LiftState currentState) {
        this.currentState = new IdleState(this);
        this.movingUpState = new MovingDownState(this);
        this.movingDownState = new MovingDownState(this);
        this.idleState = new IdleState(this);
        this.currentFloor = 0;
    }

    public boolean hasRequestInOppositeDirection(){
        char direction = currentState.getDirection();
        if (direction == 'I')
            return false;
        for (LiftRequest request : requests){
            if (request.getMoveDirection() != direction)
                return true;
        }
        return false;
    }
    private int countPeople(int floor, char direction){
        int people = 0;
        for (LiftRequest request : requests){
            if (request.getMoveDirection() == direction){
                if (direction == 'U'){
                    if (request.getSource() < floor && request.getDestination() >= floor)
                        people++;
                }
                else {
                    if (request.getMoveDirection() >= floor && request.getDestination() <= floor)
                        people++;
                }
            }
        }
        return people;
    }
    public boolean hasSpace(int source, int destination, char direction){
        if (direction == 'U'){
            for (int starting = source; starting <= destination; starting++){
                if (countPeople(starting, direction) >= 10)
                    return false;
            }
        }
        else {
            for (int start = source; start >= destination; start--){
                if (countPeople(start, direction) >= 10)
                    return false;
            }
        }
        return true;
    }
    public List<LiftRequest> getRequests(){
        return requests;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public void setState(char c){
        if (c == 'U'){
            currentState = movingUpState;
            return;
        }
        if (c == 'D'){
            currentState = movingDownState;
            return;
        }
        currentState = idleState;
    }
    public void setCurrentFloor(int floor){
        currentFloor = floor;
    }

    public void updateLift(){
        if (requests.isEmpty()){
            setState('I');
            return;
        }
        updateRequest();
        currentState.updateState();
        currentState.updateFloor();
    }

    public void updateRequest(){
        List<LiftRequest> newRequests = new ArrayList<>();
        for (LiftRequest request : requests){
            boolean passesWhileMovingUp = request.getMoveDirection() == 'U' && getCurrentFloor() > request.getDestination();
            boolean passesWhileMovingDown = request.getMoveDirection() == 'D' && getCurrentFloor() < request.getDestination();
            if (passesWhileMovingUp || passesWhileMovingDown) continue;
            newRequests.add(request);
        }
        requests = newRequests;
    }
}
