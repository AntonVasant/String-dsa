package LLD.atm;

import java.util.Random;

public class Customer {

    static int idGent = 1;
    Random random = new Random();

    private int id;
    private String name;
    private long accountNumber;

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer(String name){
        this.name = name;
        id = idGent++;
        accountNumber = generateAccountNumber();
    }
    public int getId() {
        return id;
    }

    private long generateAccountNumber(){
        return random.nextLong(9);
    }
}
