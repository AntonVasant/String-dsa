package LLD;

import java.util.Scanner;

public class PongGame {
    static int Height = 20;
    static int Width = 30;
    static char[][] board = new char[Height][Width];
    static int ballX = Height/2 ;
    static int ballY = Width/2;
    static char ball = '0';
    static char border = '*';
    static int ballDirX = 1;
    static int ballDirY = 1;
    static int Paddle1X = Height/2-2;
    static int Paddle1Y = 1;
    static int Paddle2X = Height/2-2;
    static int Paddle2Y = Width-2;
    static int padLength = 4;
    static char Paddle = '|';
    static char spaces = '.';
    Scanner scanner = new Scanner(System.in);


    void playGame(){
        while (true){
            System.out.println("Enter the move P1 : w/s  P2 : i/k");
            char move = scanner.next().charAt(0);
            handleMove(move);
            moveBall();
            print();
        }
    }


    void handleMove(char move){
        if (move == 'w'){
            if (Paddle1X > 1) {
                board[Paddle1X+padLength-1][Paddle1Y] = spaces;
                board[Paddle1X-1][Paddle1Y] = Paddle;
                Paddle1X = Paddle1X-1;
            }
        }else if (move == 's'){
            if (Paddle1X+padLength < Height-2){
                board[Paddle1X][Paddle1Y] = spaces;
                board[Paddle1X+padLength][Paddle1Y] = Paddle;
                Paddle1X = Paddle1X+1;
            }
        } else if (move == 'i') {
            if (Paddle2X > 1){
                board[Paddle2X+padLength-1][Paddle2Y] = spaces;
                board[Paddle2X-1][Paddle2Y] = Paddle;
                Paddle2X = Paddle2X-1;
            }
        } else if (move == 'k') {
            if (Paddle2X+padLength < Height-2){
                board[Paddle2X][Paddle2Y] = spaces;
                board[Paddle2X+padLength][Paddle2Y] = Paddle;
                Paddle2X = Paddle2X+1;
            }
        }
    }
    void moveBall(){
        board[ballX][ballY] = spaces;
        ballX += ballDirX;
        ballY += ballDirY;
        if (ballX == 0 || ballX == Height-1)
            ballDirX = -ballDirX;
        else if (ballX >= Paddle1X && ballX < Paddle1X+padLength && ballY == 1 ||
                ballX >= Paddle2X && ballX < Paddle2X+padLength && ballY == Width-2){
            ballDirY = -ballDirY;
        }

        board[ballX][ballY] = ball;

    }


    void initialize(){
        for (int  i = 0; i < Height; i++){
            for (int j = 0; j < Width; j++){
                if (i == ballX && j == ballY)
                    board[ballX][ballY] = ball;
                else if (i == 0 || j == 0|| i == Height-1 || j == Width -1) {
                    board[i][j] = border;
                } else if (j == 1 && i >= Paddle1X && i < Paddle1X + padLength || j == Width - 2 && i >= Paddle2X && i < Paddle2X + padLength) {
                    board[i][j] = Paddle;
                }else board[i][j] = spaces;
            }
        }
    }


    void print(){
        for (int i = 0; i < Height; i++){
            for (int j = 0; j < Width; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String a[]){
        PongGame pongGame = new PongGame();
        pongGame.initialize();
        pongGame.playGame();
    }
}
