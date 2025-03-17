package machinecoding.food;

import java.util.List;

public class ConcreteSearch implements AssignExecutiveStrategy {
    @Override
    public DeliveryExecutive searchExecutive(char pickUp, char destination, int[] time, List<DeliveryExecutive> executives) {
        DeliveryExecutive executive = null;
        for (DeliveryExecutive executive1 : executives){
            if (executive1.canIncludeOrder(time) && executive1.isSameLocation(destination)){
                Trip trip = executive1.getLastTrip();
                if (trip.canCombineOrder()){
                    return executive1;
                }


            }
        }
        return executive;
    }
}
