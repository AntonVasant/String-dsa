package machinecoding.gift;

public class Customer {

    private int id;
    private String name;
    private String password;
    private double balance;


    public Customer(int id, String name, String password, double balance) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public void print(){
        System.out.println(id+"        "+name +"        "+ balance);
    }

    public void setId(int id) {
        this.id = id;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
