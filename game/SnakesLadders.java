package game;

import java.util.*;

public class SnakesLadders {

    Random random;
    static Board board;
    static Queue<int[]> queue;
    static Map<int[], int[]> map;
    Scanner scanner;

    public SnakesLadders(int players){
        scanner = new Scanner(System.in);
        board = new Board(new int[][]{{3,4,1,8}},new int[][]{{9,8,6,5}});
        random = new Random();
        queue = new LinkedList<>();
        for (int i = 1; i <= players; i++)
            queue.offer(new int[]{i,0,0});
        map = new HashMap<>();

    }

    private void start(){
        while (true){
            printBoard();
            int[] currentPlayer = queue.poll();
            assert currentPlayer != null;
            System.out.println("Enter R to roll the dice player "+ currentPlayer[0]);
            char c = scanner.next().charAt(0);
            if (c != 'R'){
                System.out.println("Roll the dice please");
                continue;
            }

           int diceNumber = rollDice();
            int col = (currentPlayer[2] + diceNumber) % 10;
            if (col < currentPlayer[2]) currentPlayer[1]++;
            currentPlayer[2] = col;
            if (board.grid[currentPlayer[1]][currentPlayer[2]].contains("s") ||
                    board.grid[currentPlayer[1]][currentPlayer[2]].contains("l")){

            }
        }
    }

    private int rollDice(){
        return random.nextInt(6) + 1;
    }

    private void printBoard(){
        board.print();
    }

    public static void main(String[] args) {

    }
}
