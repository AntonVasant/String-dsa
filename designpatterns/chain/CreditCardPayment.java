package designpatterns.chain;

public class CreditCardPayment extends PaymentHandler{
    @Override
    void handlePayment(double amount) {
        if (amount < 500){
            System.out.println("Payment handled");
        }
        else next.handlePayment(amount);
    }
}
