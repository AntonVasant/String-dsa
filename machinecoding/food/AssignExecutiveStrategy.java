package machinecoding.food;

import java.util.List;

public interface AssignExecutiveStrategy {

    DeliveryExecutive searchExecutive(char pickUp, char destination, int[] time, List<DeliveryExecutive> executives);

    default DeliveryExecutive getMinimumWage(List<DeliveryExecutive> executives){
        DeliveryExecutive executive = null;
        double minimun = Double.MAX_VALUE;
        for (DeliveryExecutive executive1 : executives){
            if (executive1.getTotalEarnings() < minimun){
                executive = executive1;
                minimun = executive1.getTotalEarnings();
            }
        }
        return executive;
    }
}
