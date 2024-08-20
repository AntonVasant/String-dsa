package taxi;

import java.util.ArrayList;
import java.util.List;

public class TaxiBooking {
    private static List<Taxi> taxiList = new ArrayList<>();
    private static int taxiLimit = 4;
    static int idGenerator = 1;
     static List<Taxi> bookingDetails = new ArrayList<>();

    public static String booking(char pickUpLocation,char dropLocation,int pickUpTime){
        if(taxiList.size()<taxiLimit){
            taxiList.add(new Taxi());
        }
        int min = Integer.MAX_VALUE;
        Taxi taxiReady = null;
        for(Taxi t : taxiList){
            if(t.getDropTime()<=pickUpTime && Math.abs(t.getCurrentLocation()-pickUpLocation)<min){
                min = Math.abs(t.getCurrentLocation()-pickUpLocation);
                taxiReady = t;
            }
        }
        if(taxiReady != null){
            taxiReady.setCurrentLocation(dropLocation);
            taxiReady.setCustomerId(idGenerator++);
            taxiReady.setDropLocation(dropLocation);
            taxiReady.setPickUpLocation(pickUpLocation);
            taxiReady.setEarnings(taxiReady.getEarnings()+Math.abs(dropLocation-pickUpLocation)*100+(10*10));
            taxiReady.setTaxiId(taxiList.indexOf(taxiReady)+1);
            taxiReady.setDropTime(pickUpTime+Math.abs(dropLocation-pickUpLocation));
            taxiReady.setPickUpTime(pickUpTime);
            bookingDetails.add((Taxi)taxiReady);
        }
        return taxiReady!= null ? "Taxi  Number "+taxiReady.getTaxiId()+" is booked" : "no available taxi";
    }
    public static void display(){
        System.out.println("--------------------------------------------------------------------------------------");
        for(Taxi t : bookingDetails){
            System.out.println(t.toString());
            System.out.println("-----------------------------------------------------------------------------------");
        }
    }
}
