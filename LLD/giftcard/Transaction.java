package LLD.giftcard;

public class Transaction {

    private int transactionId;
    private int cardNo;
    private double amount;

    public Transaction(double amount,int transactionId,int cardNo) {
        this.amount = amount;
        this.cardNo = cardNo;
        this.transactionId = transactionId;
    }

    public int getCardNo() {
        return cardNo;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
