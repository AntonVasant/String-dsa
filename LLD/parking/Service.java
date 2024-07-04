package LLD.parking;

import javax.xml.crypto.Data;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.UUID;

public class Service {
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public Ticket parkVehicle(Vehicle vehicle) throws Exception{
           for (Spot spot : repository.getSpots()){
               if (spot.isAvailable() && isValid(spot,vehicle.getType())){
                   spot.setAvailable(false);
                   repository.spotMap.put(vehicle.getNumberPlate(),spot);
                   Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, new Date(),null);
                   repository.ticketMap.put(ticket.getId(),ticket);
                   return ticket;
               }
           }
           throw new Exception("no available spot for type "+vehicle.getType());
    }

    private boolean isValid(Spot spot,VehicleType type){
        if (spot.getType() == SpotType.COMPACT){
            return type == VehicleType.CAR || type == VehicleType.BIKE;
        } else if (spot.getType() == SpotType.HANDICAP) {
            return type == VehicleType.BIKE;
        }
        return type == VehicleType.TRUCK || type == VehicleType.CAR;
    }

    public void unParkVehicle(String id) throws Exception {
        Spot s = repository.getVehicle(id);
        if (s == null) throw new Exception("vehicle not found");
        s.setAvailable(true);
        repository.removeSpot(id);
        Ticket t = repository.getTicket(id);
        t.setTo(new Date());
        repository.removeTicket(id);
    }
}
