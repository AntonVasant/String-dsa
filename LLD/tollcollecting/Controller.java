package LLD.tollcollecting;

public class Controller {
    public Controller(Service service) {
        this.service = service;
    }

    private Service service;

    public void calculateToll(char c,char d,String type){
        double amount = service.calculateTax(c,d,type);
        System.out.println("your amount "+amount);
    }
}
