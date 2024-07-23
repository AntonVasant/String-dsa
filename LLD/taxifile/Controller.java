package LLD.taxifile;

public class Controller {

    private Service service;
    String path = "C:\\Users\\Hp\\Desktop\\String\\LLD\\taxifile\\data";

    public Controller(Service service) {
        this.service = service;
    }

    public void createTaxi(int id){
        service.createTaxi(id);
    }

    public void bookTax(char start ,char destination,String card){
        Taxi taxi = service.bookTaxi(start,destination,card);
        if (taxi == null){
            System.out.println("no taxi");
            return;
        }
        System.out.println("your taxi id "+taxi.getId());
        service.updateFile(path);
    }
    public void loadData(String path){
        service.loadData(path);
    }

    public void printAll() {
        service.printAll();
    }
}
