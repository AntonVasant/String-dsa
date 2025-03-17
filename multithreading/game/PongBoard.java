package multithreading.game;

import java.util.Scanner;

public class PongBoard {

    static Ball ball;
    static Paddle paddle1;
    static Paddle paddle2;
    static int height = 20;
    static int width=  30;
    static char[][] board = new char[height][width];
    static char wall = '#';
    static char ballType = 'O';
    static char pad = '|';
    Scanner scanner;

    public PongBoard(){
        scanner = new Scanner(System.in);

    }

    public void playGame() throws InterruptedException {
        ball = new Ball(10,15,1,1);
        paddle1 = new Paddle(4,1,8);
        paddle2 = new Paddle(4, width-2,8);
        Thread tread1 = new Thread(paddle1);
        Thread thread = new Thread(paddle2);
        thread.setDaemon(true);
        tread1.setDaemon(true);
        tread1.start();
        thread.start();

        while (!isOver()){
            ball.move();
            updateState();
            printBoard();
            Thread.sleep(500);
        }
    }

    private void updateState(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = ' ';
            }
        }

        for (int i = 0; i < paddle1.width; i++)
            board[paddle1.pos_x+i][paddle1.pos_y] = pad;

        for (int i = 0; i < paddle1.width; i++) {
            board[paddle2.pos_x+i][paddle2.pos_y] = pad;
        }

        board[ball.pos_x][ball.pos_y] = ballType;

        if (ball.pos_x == 1)
            ball.setDx(1);
        if (ball.pos_x == height-2)
            ball.setDx(-1);
        if (ball.pos_y == width-2)
            ball.setDy(-1);
        if (isColliedPad())
            ball.setDy(1);
    }

    private boolean isColliedPad(){
        return ball.pos_x <= paddle1.pos_x && ball.pos_x < paddle1.pos_x+paddle1.width && ball.pos_y == 2;
    }

    private void printBoard(){
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height-1 || j == width-1)
                    System.out.print(wall);
                else System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private boolean isOver(){
        return ball.pos_y < 0 || ball.pos_x < 0 || ball.pos_x >= height || ball.pos_y >= width;
    }
}
