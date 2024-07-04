package LLD.snakeLadder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SnakeLadderBoard {
    private final int boardSize = 100;
    Queue<Player> players;
    List<Snake> snakes;
    List<Ladder> ladders;
    Map<String,Integer> currentPlayerAndPos;
    Dice dice;

    public SnakeLadderBoard(Queue<Player> players, List<Snake> snakes,List<Ladder> ladders){
        this.ladders = ladders;
        this.players = players;
        this.snakes = snakes;
        this.currentPlayerAndPos = new HashMap<>();
        this.dice = new Dice();
    }

    void playGame(){
        while (players.size() > 1){
            Player currentPlayer = players.poll();
            int currentPos = currentPlayer.getCurrentPos();
            System.out.println("please enter p to roll the dice");
            int nextPos = currentPos+dice.diceRoll();
            if (nextPos > boardSize){
                players.offer(currentPlayer);
            } else if (nextPos == boardSize) {
                System.out.println("you have won the game");
            }
            else {
                int temp = nextPos;
               for (Snake snake : snakes){
                   if (nextPos == snake.getHead()){
                       nextPos = snake.getTail();
                       break;
                   }
               }
               if (temp != nextPos){
                   System.out.println("you have bitten by a snake");
               }

               for (Ladder ladder : ladders){
                   if (nextPos == ladder.getStart()){
                       nextPos = ladder.getEnd();
                       break;
                   }
               }
            }

        }
    }

}
