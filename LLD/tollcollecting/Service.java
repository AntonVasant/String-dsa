package LLD.tollcollecting;

import java.util.List;

public class Service {

    private  Repository repository;
    private DistanceService distanceService;

    public Service(Repository repository, DistanceService distanceService) {
        this.repository = repository;
        this.distanceService = distanceService;
    }

    public double calculateTax(char start,char destination,String vehicleType){
        List<Toll> tollList =  distanceService.getTolls(start,destination);
        double amount = 0;
        for (Toll toll : tollList)
            amount += toll.calculateToll(vehicleType);
        return amount;
    }
}
