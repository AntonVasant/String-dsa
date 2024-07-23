package LLD.taxifile;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    static List<Passenger> passengerList = new ArrayList<>();

    static List<Taxi> taxiList = new ArrayList<>();


    public void save(Passenger passenger){
        passengerList.add(passenger);
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public Passenger getPassengerByCard(String card){
        for (Passenger p : passengerList){
            if (card.equals(p.getCardNo()))
                return p;
        }
        return null;
    }

    public List<Taxi> getTaxiList() {
        return taxiList;
    }

    public void addTaxi(Taxi taxi) {
        taxiList.add(taxi);
    }
}
