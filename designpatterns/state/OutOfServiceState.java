package designpatterns.state;

public class OutOfServiceState implements ATMState{

    private ATMMachine atmMachine;

    public OutOfServiceState(ATMMachine machine){
        atmMachine = machine;
    }
    @Override
    public void cardAccept() {
        System.out.println("Atm out of service, visit nearby atm");
    }

    @Override
    public boolean enterPin(int pin) {
        System.out.println("Atm out of service, visit nearby atm");
        return false;
    }

    @Override
    public void ejectCard() {
        System.out.println("Atm out of service, visit nearby atm");
    }

    @Override
    public void enterMoney(int amount) {
        System.out.println("Atm out of service, visit nearby atm");
    }

    @Override
    public int dispenseCash() {
        System.out.println("Atm out of service, visit nearby atm");
        return 0;
    }
}
