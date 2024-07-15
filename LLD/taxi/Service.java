package LLD.taxi;

import java.security.PublicKey;
import java.util.List;

public class Service {

    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }


    public Taxi bookTaxi(char start,char end,int pickUpTime){
        Taxi taxi = getAvailableTaxi(start,pickUpTime);
        if (taxi != null){
            int earnings = calculateFare(start,end);
            taxi.setAvailable(false);
            taxi.setTotalEarnings(taxi.getTotalEarnings()+earnings);
            taxi.setAvailableTime(pickUpTime + Math.abs(start-end));
            TaxiHistory taxiHistory = generateHistory(start,end,earnings);
            taxi.getTaxiHistories().add(taxiHistory);
            return taxi;
        }
        return null;
    }

    private TaxiHistory generateHistory(char start,char des,int earnings){
        TaxiHistory taxiHistory = new TaxiHistory(start,des,earnings);
        return taxiHistory;
    }
    public void addTaxi(Taxi taxi){
        repository.addTaxi(taxi);
    }

    private int calculateFare(char start,char end){
        int distance = Math.abs(start - end);
        if (distance == 1) return 200;
        else return 200 + (distance-1)*10*15;
    }

    private Taxi getAvailableTaxi(char start,int time){
        List<Taxi> taxiList = repository.getTaxiList();
        int minLocation = Integer.MAX_VALUE;
        int earnings = Integer.MAX_VALUE;
        Taxi nearTaxi = null;
        for (Taxi taxi : taxiList){
            int difference = Math.abs(start - taxi.getCurrentLocation());
            if (taxi.getAvailableTime() <= time && difference < minLocation ||
                    taxi.getAvailableTime() <= time && difference == minLocation && earnings < taxi.getTotalEarnings()){
                nearTaxi = taxi;
                minLocation = difference;
                earnings = taxi.getTotalEarnings();
                taxi.setAvailable(true);
            }
        }
        return nearTaxi;
    }

    public void printAllTaxiHistory(){
        List<Taxi> taxiList = repository.getTaxiList();
        for (Taxi t : taxiList){
            System.out.println("Taxi id    :"+t.getTaxid());
            List<TaxiHistory> th = t.getTaxiHistories();
            for (TaxiHistory taxiHistory : th){
                System.out.println("starting  "+taxiHistory.getStart());
                System.out.println("ending    "+taxiHistory.getDes());
                System.out.println("money     "+taxiHistory.getTotalMoney());
            }
        }
    }

    public void printTaxiHistory(int taxiId){
       Taxi taxi = repository.getTaxiById(taxiId);
       int money = 0;
        List<TaxiHistory> histories = taxi.getTaxiHistories();
        for (TaxiHistory taxiHistory : histories){
            System.out.println("taxi id :"+taxi.getTaxid());
            System.out.println("Taxi start   :"+taxiHistory.getStart());
            System.out.println("Taxi  des    :"+taxiHistory.getDes());
            System.out.println("Taxi earning :"+taxiHistory.getTotalMoney());
            money += taxiHistory.getTotalMoney();
        }
        System.out.println("Taxi total Earning :"+money);
    }

    public void printAllTaxi() {
        List<Taxi> taxiList = repository.getTaxiList();
        for (Taxi taxi : taxiList){
            System.out.println(taxi.getTaxid());
            System.out.println(taxi.getCurrentLocation());
        }
    }
}
