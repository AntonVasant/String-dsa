package machinecoding.gift;

import java.util.Date;

public class Transaction {

    private int customerId;
    private String cardId;
    private double amount;
    private Date time;
    private double cardBalance;

    public Transaction(int customerId, String cardId, double amount, double cardBalance) {
        this.customerId = customerId;
        this.cardId = cardId;
        this.amount = amount;
        this.cardBalance = cardBalance;
        time = new Date();
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }
}
