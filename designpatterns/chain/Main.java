package designpatterns.chain;

public class Main {
    public static void main(String[] args) {
        PaymentHandler creditCard = new CreditCardPayment();
        PaymentHandler bankPayment = new BankPaymentHandler();
        PaymentHandler paypalPayment = new PayPalPaymentHandler();
        bankPayment.setNext(creditCard);
        creditCard.setNext(paypalPayment);
        bankPayment.handlePayment(1400);
    }
}
