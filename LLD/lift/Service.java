package LLD.lift;

import java.util.List;

public class Service {

    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public Lift assignLift(int source,int destination,int numberOfPeople){
            Lift lift = findSuitableLift(source,destination,numberOfPeople);
            if (lift != null){
                if (lift.getStatus().equals(LiftStatus.IDLE))
                    lift.setStatus(LiftStatus.MOVING);
                if (lift.getDistance(destination) < Math.abs(source - destination))
                    lift.setDestination(destination);
                lift.setCurrentPeople(lift.getCurrentPeople()+numberOfPeople);
                lift.setCurrentFloor(destination);
            }
            return lift;
    }

    private Lift findSuitableLift(int source,int destination,int people){
        List<Lift> lifts = repository.getAllLift();
        Lift best = null;
        int distance = Integer.MAX_VALUE;
        for (Lift lift : lifts){
            if (lift.isValid(source,destination,people)){
                int area = lift.getDistance(source);
                if (area < distance || distance == area && lift.isSameDirection(source,destination)){
                    best = lift;
                    distance = area;
                }
            }
        }
        return best;
    }

    public void printPosition(){
        List<Lift> lifts = repository.getAllLift();
        System.out.print("Lifts      :");
        for (Lift lift : lifts)
            System.out.print("\t"+lift.getLiftId());
        System.out.println();
        System.out.print("Positions   :");
        for (Lift lift : lifts)
            System.out.print("\t"+lift.getCurrentFloor());
        System.out.println();
    }
}
