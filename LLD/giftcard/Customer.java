package LLD.giftcard;

import java.util.Random;

public class Customer {
    Random random = new Random();
    private int id;
    private String name;
    private int accountNumber;
    private double balance;
    public Customer(String name){
        this.id = generateNumber();
        this.name = name;
        this.accountNumber = generateAccountNumber();
        balance = 500;
    }

    private int generateNumber(){
        return random.nextInt(3333);
    }
    private int generateAccountNumber(){
        return random.nextInt(33330000);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
