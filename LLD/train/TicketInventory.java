package LLD.train;

import java.util.Map;

public class TicketInventory {

    static Map<SeatType, Integer> map;
    static Map<Integer, Ticket> ticketMap;


    public void addTicket(int id, Ticket ticket){
        ticketMap.put(id, ticket);
    }

    public Ticket getTicket(int id){
        return ticketMap.get(id);
    }

    public int getAvailableSeatsForType(SeatType type){
        return map.get(type);
    }

    public boolean isSeatAvailable(SeatType type, int count){
        return map.get(type) >= count;
    }

    public void addSeats(SeatType type, int count){
        map.put(type, map.getOrDefault(type, 0)+count);
    }

    public Map<SeatType, Integer> getAllSeats(){
        return map;
    }


    public void reduceSeat(SeatType type, int count){
        map.put(type, map.getOrDefault(type, 0)- count);
    }
}
