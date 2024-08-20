package LLD.lift;

public class Controller {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void assignLift(int source,int destination,int people){
        Lift lift = service.assignLift(source,destination,people);
        if (lift != null){
            System.out.println("your lift number is "+lift.getLiftId());
        }
    }

    public void printPosition(){
        service.printPosition();
    }
}
