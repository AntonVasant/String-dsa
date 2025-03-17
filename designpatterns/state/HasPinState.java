package designpatterns.state;

public class HasPinState implements ATMState{

    private ATMMachine machine;

    public HasPinState(ATMMachine machine){
        this.machine = machine;
    }

    @Override
    public void cardAccept() {
        System.out.println("card already read");
    }

    @Override
    public boolean enterPin(int pin) {
        System.out.println("Pin already entered");
        return false;
    }

    @Override
    public void ejectCard() {
        System.out.println("card removed");
        machine.setCurrentState(machine.getNoCardState());
    }

    @Override
    public void enterMoney(int amount) {
        System.out.println("Amount "+ amount);

    }

    @Override
    public int dispenseCash() {
        return 0;
    }
}
