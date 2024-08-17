package LLD.atm;

import java.util.UUID;

public class Card {
    static int cardNoGen = 1;

    private String cardNo;
    private int cardHolderId;

    private String cardPassword;

    public Card(int accountHolder){
        this.cardHolderId = accountHolder;
        cardPassword = UUID.randomUUID().toString();
        cardNo = "1234";
    }
    public int getCardHolderId() {
        return cardHolderId;
    }

    public String getCardPassword() {
        return cardPassword;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
