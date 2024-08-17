package LLD.atm;

public class CardReader {

    public static boolean validateCard(String password,Card card){
        return password.equals(card.getCardPassword());
    }
}
