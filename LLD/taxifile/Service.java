package LLD.taxifile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class Service {

    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public void loadData(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null){
                Passenger passenger = createPassenger(line);
                repository.save(passenger);
            }
        }catch (Exception e){
            System.out.println("File not found");
        }
    }

    public void updateFile(String path){
        try {
            BufferedWriter writer  = new BufferedWriter(new FileWriter(path));
            writer.write("Name   card   balance   Routes");
            writer.newLine();
            List<Passenger> list = repository.getPassengerList();
            for (Passenger passenger : list){
                if (passenger.getRoutesTravelled() != null){
                    writer.write(passenger.getName()+"    "+
                            passenger.getCardNo()+"    "+passenger.getBalance()+"     "+passenger.getRoutesTravelled());
                }
                else writer.write(passenger.getName()+"    "+passenger.getCardNo()+"    "+passenger.getBalance());
                writer.newLine();
            }
            writer.close();
        }catch (Exception e){
            System.out.println("file not found");
            e.printStackTrace();
        }

    }

    public void printAll(){
        List<Passenger> passengerList = repository.getPassengerList();
        for (Passenger p : passengerList){
            System.out.print("Name "+p.getName()+" ");
        }
    }
    public Taxi bookTaxi(char start, char destination,String card) {
        int distance = Math.abs(start - destination);
        int fare = calculateFare(distance);
        Passenger passenger = repository.getPassengerByCard(card);
        if (passenger.getBalance() < fare) return null;
        Taxi taxi = getAvailableTaxi(start);
        if (taxi == null) return null;
        String route = start+"->"+destination;
        passenger.setRoutesTravelled(route);
        passenger.setBalance(passenger.getBalance()-fare);
        taxi.setAmount(fare);
        return taxi;
    }

    private Taxi getAvailableTaxi(char location){
        List<Taxi> taxiList = repository.getTaxiList();
        Taxi best = null;
        int minDistance = Integer.MAX_VALUE;
        for (Taxi taxi : taxiList){
            int distance = Math.abs(taxi.getCurrentLocation() - location);
            if (taxi.isAvailable && distance < minDistance){
                minDistance = distance;
                best = taxi;
            }
        }
        return best;
    }
    private Passenger createPassenger(String str){
        String[] arr = str.split("\\s+");
        if (arr.length < 2) return null;
        String name = arr[0];
        String card = arr[1];
        double balance = Double.parseDouble(arr[2]);
        return new Passenger(name,card,balance);
    }

    private int calculateFare(int n){
        if (n < 4) return n*10;
        else return 30 + 10 * (n-3);
    }

    public void createTaxi(int id) {
        Taxi taxi = new Taxi(id);
        repository.addTaxi(taxi);
    }
}
