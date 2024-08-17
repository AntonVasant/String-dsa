package LLD.atm;

public class CashDispenser {
    private ATM atm;
    public void dispenseCash(double amount){
        atm.debit(amount);
    }
}
