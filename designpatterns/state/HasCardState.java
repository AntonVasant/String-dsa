package designpatterns.state;

public class HasCardState implements ATMState{

    private ATMMachine atmMachine;

    public HasCardState(ATMMachine machine){
        atmMachine = machine;
    }
    @Override
    public void cardAccept() {
        System.out.println("Card already inserted");
    }

    @Override
    public boolean enterPin(int pin) {
        if (isPinCorrect(pin,1)){
            atmMachine.setCurrentState(atmMachine.getHasPin());
            return true;
        }
        return false;
    }

    @Override
    public void ejectCard() {
        System.out.println("card ejected");
        atmMachine.setCurrentState(atmMachine.getNoCardState());
    }

    @Override
    public void enterMoney(int amount) {
        System.out.println("Enter pin");
    }

    @Override
    public int dispenseCash() {
        System.out.println("Enter pin and get cash");
        return 0;
    }

    private boolean isPinCorrect(int pin, int id){
        return true;
    }
}
