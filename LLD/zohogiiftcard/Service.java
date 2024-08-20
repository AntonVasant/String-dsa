package LLD.zohogiiftcard;
import java.util.List;
import java.util.Scanner;

public class Service {
    private static int idGen = 1;
    private Repository repository;
    public Service(Repository repository) {
        this.repository = repository;
    }

    public boolean login(String password,int id){
        Customer customer = repository.findCustomerById(id);
        if (customer != null){
            if (customer.getDecryptedPassword().equals(password)) return true;
        }
        return false;
    }

    public GiftCard createGiftCard(int customerId,double amount){
        Customer customer = repository.findCustomerById(customerId);
        if (customer == null || customer.getAccountBalance() < amount) return null;
        GiftCard giftCard = new GiftCard(amount,customerId);
        repository.saveGiftCard(giftCard,customerId);
        customer.setAccountBalance(customer.getAccountBalance()- amount);
        return giftCard;
    }

    public boolean topUp(int cusId,double amount,int cardNo){
        GiftCard giftCard = repository.findGiftCardById(cusId);
        if (giftCard != null && giftCard.getId() == cardNo || giftCard.getStatus().equalsIgnoreCase("block")){
            giftCard.setBalance(giftCard.getBalance()+amount);
            Customer customer = repository.findCustomerById(cusId);
            customer.setAccountBalance(customer.getAccountNumber()-amount);
            return true;
        }
        return false;
    }
    public void printAllTransaction(){
        List<List<Transaction>> lists = repository.getAllTransaction();
        System.out.println("------------------------------------------------------------------------------");
        String format = "%-15d%-15d%-15d%";
        System.out.printf("%-15s%-15s%-15s","Amount","Account Number","Transaction Id");
        System.out.println();
        for (List<Transaction> transactions : lists){
            for (Transaction transaction : transactions){
                System.out.printf(format,transaction.getAmount(),transaction.getCardNo(),transaction.getId());
            }
        }
    }
    public Transaction purchase(int cusId,int cardPassword,double amount){
        Customer customer = repository.findCustomerById(cusId);
        GiftCard giftCard = repository.findGiftCardById(cusId);
        if (customer == null || giftCard == null || giftCard.getPassword() != cardPassword || giftCard.getStatus().equalsIgnoreCase("block"))
            return null;
        if (giftCard.getBalance() < amount){
            System.out.println("Not enough balance");
            return null;
        }
        giftCard.setBalance(giftCard.getBalance()-amount);
        Transaction transaction = new Transaction(idGen++,giftCard.getId(),amount);
        customer.getTransactions().add(transaction);
        return transaction;
    }

    public boolean blockCard(int cusId,int cardNo){
        GiftCard giftCard = repository.findGiftCardById(cusId);
        if (giftCard == null || cardNo != giftCard.getId()) return false;
        giftCard.setStatus("block");
        return true;
    }
}
