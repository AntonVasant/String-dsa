package game;

import java.util.Random;
import java.util.Scanner;

import static game.SnakeAndLadder.ladders;
import static game.SnakeAndLadder.snakes;

public class Main {
    public static  void main(String a[]){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int playerPosition =0;
        int position=0;
        while (true){
            System.out.println("Enter r for rolling the dice");
            String str = sc.next();
            if(str.equalsIgnoreCase("r")){
                 position = random.nextInt(6)+1;
            }
            playerPosition += position;
            if(snakes.containsKey(playerPosition)){
                System.out.println("you have encountered a snake");
                playerPosition = snakes.get(playerPosition);
                System.out.println("your position is "+playerPosition);
            } else if (ladders.containsKey(playerPosition)) {
                System.out.println("you have encountered a ladder");
                playerPosition = ladders.get(playerPosition);
                System.out.println("your position is "+playerPosition);
            } else if (playerPosition > 100) {
                System.out.println("you need a perfect roll to win the game");
                playerPosition -= position;
                System.out.println("your position is "+playerPosition);
            } else if (playerPosition == 100) {
                System.out.println("good job you won the game");
                break;
            }
            else System.out.println("your position is "+playerPosition);

        }

        }
    }
