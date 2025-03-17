package designpatterns.state;

public class ATMMachine {

    static int totalAmount;
    private ATMState noCardState;
    private ATMState hasCardState;
    private ATMState hasPin;
    private ATMState outOfServiceState;
    private ATMState currentState;

    public ATMMachine(int totalAmount){
        noCardState = new NoCardState(this);
        hasCardState = new HasCardState(this);
        hasPin = new HasPinState(this);
        outOfServiceState = new OutOfServiceState(this);
        ATMMachine.totalAmount = totalAmount;
        setCurrentState(noCardState);
    }
    public void setCurrentState(ATMState state){
        currentState = state;
    }

    public ATMState getCurrentState(){
        return currentState;
    }

    public ATMState getNoCardState() {
        return noCardState;
    }

    public ATMState getHasCardState() {
        return hasCardState;
    }

    public ATMState getHasPin() {
        return hasPin;
    }

    public ATMState getOutOfServiceState() {
        return outOfServiceState;
    }

    public void insertCard(){
        currentState.cardAccept();
    }

    public boolean enterPin(int pin){
       return currentState.enterPin(pin);
    }

    public void enterAmount(int amount){
        currentState.enterMoney(amount);
    }
    public void dispenseCash(){
        currentState.dispenseCash();
    }
}
