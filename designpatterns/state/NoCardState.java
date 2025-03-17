package designpatterns.state;

public class NoCardState implements ATMState{
    private ATMMachine atmMachine;

    public NoCardState(ATMMachine machine){
        atmMachine = machine;
    }

    @Override
    public void cardAccept() {
        System.out.println("card accepted");
        atmMachine.setCurrentState(atmMachine.getHasCardState());
    }

    @Override
    public boolean enterPin(int pin) {
        System.out.println("enter card first");
        return false;
    }

    @Override
    public void ejectCard() {
        System.out.println("No card inserted to remove");
    }

    @Override
    public void enterMoney(int amount) {
        System.out.println("Enter card");
    }

    @Override
    public int dispenseCash() {
        System.out.println("No card inserted");
        return 0;
    }
}
