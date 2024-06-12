package bank;

public class Customer {
    int customerId;
    String name;
    String password;
    int balance;
    long accountId;

    public Customer(int accountId, int i, String detail, String detail1,int balance) {
        this.accountId = accountId;
        this.customerId = i;
        this.name = detail;
        this.password=detail1;
        this.balance = balance;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;

    }

    public Customer(long accountId) {
        this.accountId = accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
