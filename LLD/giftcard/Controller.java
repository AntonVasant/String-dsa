package LLD.giftcard;

public class Controller {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void createGiftCard(int account,double amount){
        GiftCard card = service.createCard(amount,account);
        if(card == null){
            System.out.println("no balance");
            return;
        }
        System.out.println("your card created no "+card.getCardNo());
        System.out.println("your secrete number "+card.getPin());
    }

    public void topUp(int pin,double amount,int cardNo){
        double balance = service.topUp(pin,amount,cardNo);
        if (balance == 0){
            System.out.println("not found");
            return;
        }
        System.out.println("topup successful balance = " + balance);
    }

    public void createCustomer(String name){
        int n = service.createCustomer(name);
        System.out.println("Customer created "+n);
    }

    public void purchase(int id,double amount,int pin){
        Transaction transaction = service.purchase(id,amount,pin);
        if (transaction != null){
            System.out.println("Transaction is Successful your transaction id "+transaction.getTransactionId()
            +"for amount "+transaction.getAmount());
        }
    }

    public void printAllCustomer(){
        service.printAllCustomer();
    }
}
