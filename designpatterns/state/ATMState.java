package designpatterns.state;

public interface ATMState {

    void cardAccept();
    boolean enterPin(int pin);
    void ejectCard();
    void enterMoney(int amount);
    int dispenseCash();
}
