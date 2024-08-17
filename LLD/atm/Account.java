package LLD.atm;

public class Account {
    private long accountNumber;
    private int accountHolder;
    private String cardNo;
    private double balance;


    public Account(long accountNumber,int accountHolder,String cardNo){
        this.accountHolder = accountHolder;
        this.accountNumber =accountNumber;
        this.cardNo = cardNo;
        balance = 1000000;
    }
    public int getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(int accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
}
