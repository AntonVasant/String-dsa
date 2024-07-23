package LLD.giftcard;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private static Map<Integer,GiftCard> giftCardMap = new HashMap<>();
    private static Map<Integer,Customer> customerMap = new HashMap<>();
    private static Map<Integer,Transaction> transactionMap = new HashMap<>();

    public void saveTransaction(int id,Transaction transaction){
        transactionMap.put(id,transaction);
    }
    public void saveCard(int cardNo, GiftCard giftCard) {
        giftCardMap.put(cardNo,giftCard);
    }

    public void saveCustomer(int id, Customer customer) {
        customerMap.put(id,customer);
    }

    public Customer findCustomerByAccount(int account) {
        return customerMap.get(account);
    }

    public GiftCard findCardById(int cardNo) {
        return giftCardMap.get(cardNo);
    }

    public Map<Integer, Customer> getCustomerMap() {
        return customerMap;
    }

    public Map<Integer, GiftCard> getGiftCardMap() {
        return giftCardMap;
    }

    public void setGiftCardMap(Map<Integer, GiftCard> giftCardMap) {
        this.giftCardMap = giftCardMap;
    }

    public void setCustomerMap(Map<Integer, Customer> customerMap) {
        this.customerMap = customerMap;
    }
}
