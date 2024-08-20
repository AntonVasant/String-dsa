package LLD.zohogiiftcard;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int id;
    private String name;
    private int accountNumber;
    private double accountBalance;
    private String password;
    private List<Transaction> transactions;
    public int getId() {
        return id;
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

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this. password = getEncryptedPassword(password);
    }

    public Customer(int id, String name, int accountNumber, double accountBalance) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        transactions = new ArrayList<>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getEncryptedPassword(String pass){
        StringBuilder sb = new StringBuilder();
        for (char c : pass.toCharArray()){
            if (c >= 'a' && c <= 'z'){
                if (c == 'a')
                    sb.append('z');
                else sb.append((char) (c-1));
            }
            else if (c >= 'A' && c <= 'Z'){
                if (c == 'A')
                    sb.append('Z');
                else sb.append((char) (c-1));
            }
            else sb.append(c);
        }
        return sb.toString();
    }
    public String getDecryptedPassword(){
        StringBuilder sb = new StringBuilder();
        for (char c : password.toCharArray()){
            if (c >= 'a' && c <= 'z'){
                if (c == 'z')
                    sb.append('a');
                else sb.append((char) (c+1));
            }
            else if (c >= 'A' && c <= 'Z'){
                if (c == 'Z')
                    sb.append('A');
                else sb.append((char) (c+1));
            }
            else sb.append(c);
        }
        return sb.toString();
    }
}
