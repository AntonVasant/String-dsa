package LLD.lift;

import java.util.*;

public class Repository {
    private static List<Lift> lift;
    public Repository(){
        lift = new LinkedList<>();
        Lift lift1 = new Lift(1,0,0,0,5,5,0,LiftStatus.IDLE);
        lift.add(lift1);
        Lift lift2 = new Lift(2,0,0,0,6,5,0,LiftStatus.IDLE);
        Lift lift3 = new Lift(3,0,0,0,6,10,6,LiftStatus.IDLE);
        Lift lift4 = new Lift(4,0,0,0,5,10,6,LiftStatus.IDLE);
        Lift lift5 = new Lift(5,0,0,0,5,10,0,LiftStatus.IDLE);
        lift.add(lift2);
        lift.add(lift3);
        lift.add(lift4);
        lift.add(lift5);
        Collections.reverse(lift);
    }
    public List<Lift> getAllLift(){
        return lift;
    }



}
