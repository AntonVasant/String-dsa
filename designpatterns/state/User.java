package designpatterns.state;

public class User {

    private String name;
    private String pin;
    private double balance;

    public User(String name, String pin, double balance){
        this.pin = pin;
        this.balance = balance;
        this.name = name;
    }

    public boolean verifyPin(String pin){
        return this.pin.equals(pin);
    }
    public void withdrawAmount(double amount){
        setBalance(getBalance() - amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
