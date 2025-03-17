package designpatterns.chain;

public class BankPaymentHandler extends PaymentHandler{
    @Override
    void handlePayment(double amount) {
        if (amount < 500){
            System.out.println("Handled by bank "+amount);
        }
        else next.handlePayment(amount);
    }
}
