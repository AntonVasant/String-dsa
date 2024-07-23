package LLD.giftcard;

import java.util.Random;

public class GiftCard {
    Random random = new Random();
    private int cardNo;
    private int accountHolder;
    private boolean isBlocked;
    private double balance;
    private int pin;

    public GiftCard(int cardNo,int accountHolder,double balance) {
        this.accountHolder = accountHolder;
        this.balance  =balance;
        isBlocked = false;
        pin = generatePin();
        this.cardNo = cardNo;
    }

    private int generatePin(){
        return random.nextInt(1000);
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(int accountHolder) {
        this.accountHolder = accountHolder;
    }
}
