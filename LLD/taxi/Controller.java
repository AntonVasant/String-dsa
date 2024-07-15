package LLD.taxi;

public class Controller {
    private static int idGenerator = 1;
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }



    public void printAllTaxiHis(){
        service.printAllTaxiHistory();
    }
    public void printAllTaxi(){
        service.printAllTaxi();
    }
    public void addTaxi(){
        Taxi taxi = new Taxi(idGenerator++);
        service.addTaxi(taxi);
    }

    public void bookTaxi(char start,char end,int time){
       Taxi taxi = service.bookTaxi(start,end,time);
       if (taxi != null){
           System.out.println("Your taxi id :"+taxi.getTaxid());
       }
    }

    public void printHistory(int n){
        service.printTaxiHistory(n);
    }
}
