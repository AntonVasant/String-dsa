package LLD.brick;

import java.util.*;

public class Board {
    private String[][] board;
    private Ball ball;
    private Map<Integer, Integer> bricks;


    public void detectCollision(){
        int moveX = ball.getMovingX();
        int moveY = ball.getMovingY();
        if (board[ball.getBallX()][moveY + ball.getBallY()].equals("1") || board[moveX + ball.getBallX()][ball.getBallY()].equals("1")){
            int position = getAbsolutePosition(new int[]{moveX+ ball.getBallX(), moveY + ball.getBallY()});
            bricks.put(position, bricks.getOrDefault(position, 0) -1);
            if (bricks.get(position) <= 0){
                bricks.remove(position);
                int[] boardPosition = getBoardValue(position);
                board[boardPosition[0]][boardPosition[1]] = " ";
            }
        }

        if ("1".contains(board[ball.getBallX() + ball.getMovingX()][ball.getBallY()])){
            ball.setMovingX(ball.getMovingX() * -1);
        }

        if ("1w".contains(board[ball.getBallX()][ball.getBallY() + ball.getMovingY()])){
            ball.setMovingY(ball.getMovingY() * -1);
        }
    }
    public void printBoard(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public void renderGame(){
        board[ball.getBallX()][ball.getBallY()] = " ";
        board[ball.getBallX() + ball.getMovingX()][ball.getBallY() + ball.getMovingY()] = "0";
        ball.setBallX(ball.getBallX() + ball.getMovingX());
        ball.setBallY(ball.getBallY() + ball.getMovingY());
    }

    public void playGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter U or L or R");
        char c = scanner.next().charAt(0);
        int direction = 0;
        if (c == 'L')
            direction = -1;
        else if (c == 'R')
            direction = 1;
        ball.setMovingX(-1);
        ball.setMovingY(direction);
        boolean first = true;
        while (first || ball.getBallX() <= 5){
            first = false;
            detectCollision();
            renderGame();
            printBoard();
            System.out.println(ball.getBallX()+ " "+ ball.getBallY());
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Ball ball1 = new Ball(6,5);
        Board board1 = new Board(ball1, new ArrayList<>(Arrays
                .asList(new int[]{2,3},
                        new int[]{2,4},
                        new int[]{2,5},
                        new int[]{2,6},
                        new int[]{3,3},
                        new int[]{3,4},
                        new int[]{3,5},
                        new int[]{3,6})),7);
        while (true)
             board1.playGame();

    }

    public int[] getBoardValue(int position){
        int length = board[0].length;
        int[] ans = new int[2];
        ans[0] = position/length;
        ans[1] = position % length;
        return ans;
    }
    public Board(Ball ball, List<int[]> bricks, int size){
        this.ball = ball;
        this.bricks = new HashMap<>();
        board = new String[size][9];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = " ";
                if (i == 0 || j == 0 || i == 6  || j == 8)
                    board[i][j] = "w";
            }
        }

        for (int[] arr : bricks){
            int pos = getAbsolutePosition(arr);
            this.bricks.put(pos, 2);
        }
        for (int[] arr : bricks){
            board[arr[0]][arr[1]] = "w";
        }
        board[ball.getBallX()][ball.getBallY()] = "0";


    }
    private int getAbsolutePosition(int[] arr ){
        int position = arr[0] * board[0].length;
        position += arr[1];
        return position;
    }
}
