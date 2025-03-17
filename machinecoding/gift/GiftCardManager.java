package machinecoding.gift;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GiftCardManager {


    private static Map<String, GiftCard> giftCardMap;
    private Random random;
    private AccountManager manager;

    public GiftCardManager(AccountManager manager1){
        giftCardMap = new HashMap<>();
        random = new Random();
        manager = manager1;
    }

    public GiftCardResponse createGiftCard(int holderId){
        String cardNumber = generateNumber(4);
        String generatePassword = generateNumber(5);
        GiftCard card = new GiftCard(cardNumber, generatePassword,0,holderId);
        giftCardMap.put(cardNumber, card);
        return new GiftCardResponse(cardNumber, generatePassword);
    }

    private String generateNumber(int length){
        int bound = 1;
        int limit = 1;
        for (int i = 0; i < length; i++){
            bound *= 10;
            limit *= 9;
        }
        int num = random.nextInt(bound, limit);
        return Integer.toString(num);
    }

    public boolean verifyUser(int holderId, String password){
        GiftCard card = getCardByUserId(holderId);
        if (card == null) return false;
        return card.getPassword().equals(password);
    }

    public Transaction topUp(int holderId, double amount){
        GiftCard card = getCardByUserId(holderId);
        assert card != null;
        card.setBalance(card.getBalance() + amount);
        Transaction transaction = new Transaction(holderId,card.getCardNumber(),amount, card.getBalance());
        card.addTransaction(transaction);
        return transaction;
    }

    public boolean blockCard(int cus){
        GiftCard card = getCardByUserId(cus);
        assert card != null;
        beginBlockingRequest(card);
        card.setBlocked(true);
        return true;
    }


    private void beginBlockingRequest(GiftCard card){
        int holder = card.getCardHolderId();
        double total = card.getBalance();
        manager.addMoney(holder,total);
    }


    public void printTransaction(int customer){
        GiftCard card = getCardByUserId(customer);
        assert card != null;
        for (Transaction transaction : card.getTransactions()){
            System.out.println(transaction.getCardId()+" "+ transaction.getAmount()+" "+
                    transaction.getCardBalance() + transaction.getTime().toString());
        }
    }
    private GiftCard getCardByUserId(int id){
        for (GiftCard card : giftCardMap.values()){
            if (card.getCardHolderId() == id)
                return card;
        }
        return null;
    }
}
