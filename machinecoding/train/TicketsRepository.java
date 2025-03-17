package machinecoding.train;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TicketsRepository {


    private static int[] seatsPerStops;

    private static Map<Integer, Ticket> ticketMap;

    public TicketsRepository(int stops, int perSpace){
        seatsPerStops = new int[stops];
        ticketMap = new HashMap<>();
    }

   public int[] getSeatsPerStops(){
       return seatsPerStops;
   }

   public void lowerSeats(char source, char destination, int seats){
       for (int i  = source - 'A'; i <= destination  - 'A'; i++){
           seatsPerStops[i] += seats;
       }
   }

   public void cancelSeats(char source, char destination, int seats){
       for (int i  = source - 'A'; i <= destination  - 'A'; i++){
           seatsPerStops[i] -= seats;
       }
   }

   public void addTicket(int id, Ticket ticket){
        ticketMap.put(id, ticket);
   }
   public Ticket getTicketById(int id){
        if (ticketMap.containsKey(id))
            return ticketMap.get(id);
        return null;
   }

   public void removeTicket(int id){
       ticketMap.remove(id);
   }
}
