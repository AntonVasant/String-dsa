package LLD.taxi;

import java.util.List;

public interface TaxiAllocation {

    Taxi findTaxi(List<Taxi> taxis,  char from, char to, int time);
}
