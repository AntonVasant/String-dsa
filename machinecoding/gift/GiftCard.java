package machinecoding.gift;

import java.util.ArrayList;
import java.util.List;

public class GiftCard {
    private String cardNumber;
    private String password;
    private double balance;
    private int cardHolderId;
    private List<Transaction> transactions;
    private boolean blocked;

    public GiftCard(String cardNumber, String password, double balance, int cardHolderId) {
        this.cardNumber = cardNumber;
        this.password = password;
        this.balance = balance;
        this.cardHolderId = cardHolderId;
        transactions = new ArrayList<>();
        blocked = false;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCardHolderId() {
        return cardHolderId;
    }

    public void setCardHolderId(int cardHolderId) {
        this.cardHolderId = cardHolderId;
    }

    public void addTransaction(Transaction transaction){
        if (!blocked)
            transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
