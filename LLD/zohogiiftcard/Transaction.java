package LLD.zohogiiftcard;

public class Transaction {
    private int id;
    private int cardNo;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardNo() {
        return cardNo;
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

    public Transaction(int id, int cardNo, double amount) {
        this.id = id;
        this.cardNo = cardNo;
        this.amount = amount;
    }
}
