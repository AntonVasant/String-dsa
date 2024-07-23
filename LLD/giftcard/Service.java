package LLD.giftcard;

public class Service {

    private Repository repository;
    private GiftCardFactory giftCardFactory;

    private static int transactionIdGen = 0;
    public Service(Repository repository,GiftCardFactory giftCardFactory) {
        this.repository = repository;
        this.giftCardFactory = giftCardFactory;
    }

    public GiftCard createCard(double amount, int account) {
        Customer customer = repository.findCustomerByAccount(account);
        if (customer.getBalance() >= amount){
            customer.setBalance(customer.getBalance() - amount);
            GiftCard giftCard = giftCardFactory.createCard(account,amount);
            repository.saveCard(giftCard.getCardNo(),giftCard);
            return giftCard;
        }
        return null;
    }


    public int createCustomer(String name) {
        Customer customer  = new Customer(name);
        repository.saveCustomer(customer.getAccountNumber(),customer);
        return customer.getAccountNumber();
    }

    public double topUp(int pin, double amount, int cardNo) {
        GiftCard card = repository.findCardById(cardNo);
        double balance = 0;
        if (card == null) return 0;
        if (pin == card.getPin()){
            card.setBalance(card.getBalance()+amount);
            balance = card.getBalance();
        }
        return balance;
    }

    public void printAllCustomer(){
        System.out.println("---------------------------------------------------");
        System.out.printf("%-15s%-20s%-10s","Name","Account no","Balance");
        System.out.println();
        String formatter = "%-15s%-15d%-10f";
        System.out.println("---------------------------------------------------");
        for (Customer customer : repository.getCustomerMap().values()){
            System.out.printf(formatter,customer.getName(),customer.getAccountNumber(),customer.getBalance());
            System.out.println();
        }
    }

    public Transaction purchase(int cardNo, double amount, int pin) {
        Customer customer = repository.findCustomerByAccount(cardNo);
        GiftCard giftCard = repository.findCardById(customer.getAccountNumber());
        if (giftCard == null) return null;
        if (giftCard.getPin() == pin){
            if (doTransaction(giftCard,amount)){
                Transaction transaction = generateTransaction(amount,cardNo);
                repository.saveTransaction(transaction.getTransactionId(),transaction);
                return transaction;
            }
        }
        return null;
    }

    private Transaction generateTransaction(double amount,int cardNo){
        return new Transaction(amount,transactionIdGen++,cardNo);
    }

    private boolean doTransaction(GiftCard giftCard,double amount){
        if (giftCard.getBalance() < amount) return false;
        giftCard.setBalance(giftCard.getBalance() - amount);
        return true;
    }
}
