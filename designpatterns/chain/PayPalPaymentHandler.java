package designpatterns.chain;

public class PayPalPaymentHandler extends PaymentHandler{
    @Override
    void handlePayment(double amount) {
        if (amount < 1500)
            System.out.println("handled by paypal amount "+ amount);
       else System.out.println("too much to handle");
    }
}
