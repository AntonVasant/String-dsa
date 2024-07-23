package LLD.giftcard;

public class GiftCardFactory {
    private static  int idGen= 1;
    public GiftCard createCard(int account,double amount){
        return new GiftCard(idGen++,account,amount);
    }
}
