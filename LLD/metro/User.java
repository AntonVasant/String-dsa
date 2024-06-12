package LLD.metro;

public class User {
    private String name;
    private String cardNo;
    private int balance;
    private String lastDestination;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getLastDestination() {
        return lastDestination;
    }

    public void setLastDestination(String lastDestination) {
        this.lastDestination = lastDestination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name, String cardNo, int balance){
        this.name = name;
        this.cardNo = cardNo;
        this.balance = balance;
    }
}
