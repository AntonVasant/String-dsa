package LLD.parking;

import java.util.*;

public class Repository {

    static List<Spot> spots = new ArrayList<>();
    static Map<String,Spot> spotMap = new HashMap<>();
    static Map<String,Ticket> ticketMap = new HashMap<>();
    public List<Spot> getSpots() {
        return spots;
    }
    public void addSpots(){
        spots.add(new Spot(UUID.randomUUID().toString(),true,SpotType.COMPACT));
        spots.add(new Spot(UUID.randomUUID().toString(),true,SpotType.HANDICAP));
        spots.add(new Spot(UUID.randomUUID().toString(),true,SpotType.LARGE));
    }
    public Spot getVehicle(String id){
        return spotMap.getOrDefault(id, null);
    }

    public void removeSpot(String id) {
        spotMap.remove(id);
    }

    public Ticket getTicket(String id) {
       return ticketMap.get(id);
    }

    public void removeTicket(String id) {
        ticketMap.remove(id);
    }

    public void details(){
        for (Spot s : spots){
            System.out.println(s.getType() + s.getSpotId());
        }
    }
}
