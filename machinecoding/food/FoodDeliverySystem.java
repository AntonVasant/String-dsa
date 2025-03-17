package machinecoding.food;


import java.util.List;

public class FoodDeliverySystem {

    private static List<DeliveryExecutive> executives;

    private AssignExecutiveStrategy strategy;

    public FoodDeliverySystem(AssignExecutiveStrategy strategy, List<DeliveryExecutive> list) {
        this.strategy = strategy;
        executives = list;
    }

    public DeliveryExecutive handleBookingRequest(char source, char destination, String time){
       int[] times = parseTime(time);
       DeliveryExecutive suitable =  strategy.searchExecutive(source, destination, times, executives);
       if (suitable != null) return suitable;

       DeliveryExecutive executive = strategy.getMinimumWage(executives);
       if (executive == null){
           System.out.println("Cannot process");
           return null;
       }

       Trip trip = new Trip(executive.getId(),source, destination);
       int[] deliveryTime = getDeliveryTime(times);
       trip.setDeliveryTime(deliveryTime);
       executive.setLastPickUpTime(times);
       executive.setCurrentLocation(destination);
       executive.addTrip(trip);
       return executive;
    }

    private int[] getDeliveryTime(int[] time){
        int hour =  60 - time[1] > 15 ? time[0]+1 : time[0];
        int min = time[1] + 15 % 60;
        return new int[]{hour, min};
    }


    private int[] parseTime(String time){
        String[] times = time.split(":");
        return new int[]{Integer.parseInt(times[0]), Integer.parseInt(times[1])};
    }

    public void printStatus(){
        System.out.printf("%-20s%s","Delivery Executive","Earnings");
        System.out.println();
        for (DeliveryExecutive deliveryExecutive : executives){
            deliveryExecutive.printDetailsOfAgent();
            System.out.println();
        }
    }

    public void printDetailsOfAllAgents(){

    }


}
