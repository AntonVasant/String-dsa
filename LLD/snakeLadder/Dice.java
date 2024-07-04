package LLD.snakeLadder;

import java.util.Random;

public class Dice {
    int numberOfDices;

    public int diceRoll(){
        Random random = new Random();
        return random.nextInt(6)+1;
    }
}
