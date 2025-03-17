package designpatterns.chain;

public abstract class PaymentHandler {
    public PaymentHandler next;

    public void setNext(PaymentHandler next){
        this.next = next;
    }
    abstract void handlePayment(double amount);


}
