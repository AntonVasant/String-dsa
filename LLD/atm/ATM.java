package LLD.atm;

public class ATM {
    private double remainingAmount;
    private Location location;
    private int id;
    private Printer printer;
    private DepositSlot cashDepositSlot;
    private DepositSlot chequeSlot;


    public double debit(double amount){
        remainingAmount -= amount;
        return amount;
    }
}
