package LLD.zohogiiftcard;

import java.util.Random;

public class GiftCard {
    private int id;
    private int password;
    private double balance;
    private int accountHolderId;
    private String status;

    public GiftCard(double balance, int accountHolderId) {
        this.id = generateCardNumber();
        this.password = generatePassword();
        this.balance = balance;
        this.accountHolderId = accountHolderId;
        status = "nonblock";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public int generateCardNumber(){
        Random random = new Random();
        return random.nextInt(6);
    }
    public int generatePassword(){
        Random random = new Random();
        return random.nextInt(5);
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountHolderId() {
        return accountHolderId;
    }

    public void setAccountHolderId(int accountHolderId) {
        this.accountHolderId = accountHolderId;
    }
}
