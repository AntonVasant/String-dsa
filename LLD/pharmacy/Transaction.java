package LLD.pharmacy;

import java.util.Date;
import java.util.List;

public class Transaction {
    private int transactionId;
    private int customerId;
    private List<Purchase> purchases;
    private Date date;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Transaction(int transactionId, int customerId, List<Purchase> purchases, Date date) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.purchases = purchases;
        this.date = date;
    }
}
