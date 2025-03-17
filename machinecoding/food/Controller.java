package machinecoding.food;

;

public class Controller {

    private FoodDeliverySystem system;
    public void handleRequestForOrder(char source, char destination, String time, int cus){
        DeliveryExecutive executive = system.handleBookingRequest(source, destination,time);

        System.out.println("Customer id "  + cus);
        system.printStatus();
        System.out.println("Agent allocated id " + executive.getId());
    }

    public Controller(FoodDeliverySystem system){
        this.system = system;
    }



}
