package LLD.zohogiiftcard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    private static Map<Integer,Customer> customerMap;
    private static Map<Integer,GiftCard> giftCardMap;
    public Repository(){
        customerMap = new HashMap<>();
        giftCardMap = new HashMap<>();
        Customer cus1 = new Customer(1,"Anton",812486,10000);
        cus1.setPassword("anton2002");
        Customer cus2 = new Customer(2,"Mershesha",962651,10000);
        cus2.setPassword("mershe2006");
        Customer cus3 = new Customer(3,"Ananya",812486,10000);
        cus3.setPassword("ananya2001");
        customerMap.put(1,cus1);
        customerMap.put(2,cus2);
        customerMap.put(3,cus3);
    }

    public Customer findCustomerById(int id){
        if (customerMap.containsKey(id))
            return customerMap.get(id);
        return null;
    }
    public GiftCard findGiftCardById(int id){
        if (giftCardMap.containsKey(id))
            return giftCardMap.get(id);
        return null;
    }

    public void saveGiftCard(GiftCard giftCard,int cusId){
        giftCardMap.put(cusId,giftCard);
    }

    public List<List<Transaction>> getAllTransaction(){
        List<List<LLD.zohogiiftcard.Transaction>> lists = new ArrayList<>();
        for (Customer customer : customerMap.values()){
            lists.add(customer.getTransactions());
        }
        return lists;
    }
}
