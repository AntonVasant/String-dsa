package LLD.taxi;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    static List<Taxi> taxiList = new ArrayList<>();

    public List<Taxi> getTaxiList() {
        return taxiList;
    }

    public void setTaxiList(List<Taxi> taxiList) {
        this.taxiList = taxiList;
    }

    public void addTaxi(Taxi taxi){
        taxiList.add(taxi);
    }
    public Taxi getTaxiById(int  id){
        for (Taxi taxi1 : taxiList){
            if (taxi1.getTaxid() == id)
                return taxi1;
        }
        return null;
    }
}
