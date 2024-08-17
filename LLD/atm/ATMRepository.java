package LLD.atm;

import java.util.HashMap;
import java.util.Map;

public class ATMRepository {
    private Map<Integer,Customer> customerMap = new HashMap<>();
    private Map<Integer,Card> cardMap = new HashMap<>();

    private Map<Long,Account> accountMap = new HashMap<>();

    public Customer findCustomerById(int id){
        if (customerMap.containsKey(id))
            return customerMap.get(id);
        return null;
    }
    public void add(Customer customer,Card card,Account account){
        customerMap.put(customer.getId(),customer);
        cardMap.put(card.getCardHolderId(),card);
        accountMap.put(account.getAccountNumber(), account);
    }
    public Card findCardByHolderId(int id){
        if (cardMap.containsKey(id))
            return cardMap.get(id);
        return null;
    }
    public void update(Account account){
        accountMap.put(account.getAccountNumber(), account);
    }
    public Account getAccountByNumber(long number){
        if (accountMap.containsKey(number))
            return accountMap.get(number);
        return null;
    }

    public void addCustomer(Customer customer){
        customerMap.put(customer.getId(),customer);
    }
    public boolean addCard(Card card){
        if (customerMap.containsKey(card.getCardHolderId())){
            cardMap.put(card.getCardHolderId(),card);
            return true;
        }
        return false;
    }
}
