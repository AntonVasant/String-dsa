package LLD.taxi;

import java.util.List;

public class NearestTaxiAllocationStrategy implements TaxiAllocation{
    @Override
    public Taxi findTaxi(List<Taxi> taxis, char from, char to, int time) {
        Taxi taxi = null;
        double fare = Double.MAX_VALUE;
        int distance = 100;
        for (Taxi taxi1 : taxis) {
            if (!taxi1.isFree(time)) continue;
            int  distanceCondition = Math.abs(taxi1.getCurrentLocation() - from);
            if (distanceCondition  < distance|| distanceCondition == distance && taxi1.getTotalEarnings() < fare){
                taxi = taxi1;
                fare = taxi1.getTotalEarnings();
                distance = distanceCondition;
            }
        }

        return taxi;
    }
}
