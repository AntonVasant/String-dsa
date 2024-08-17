package LLD.atm;

import LLD.atm.exception.AccountNotFoundException;

public class Controller {
    private final ATMService service;

    public Controller(ATMService service) {
        this.service = service;
    }

    public void deposit(double amount,String card,int id) throws AccountNotFoundException {
        double m = service.depositCash(amount, card,id);
        System.out.println("your balance "+m);
    }

    public void createAccount(String name){
       long number =  service.createAccount(name);
        System.out.println(number+" is your account number");
    }
}
