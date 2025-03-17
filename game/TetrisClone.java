package game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TetrisClone {

    private static int[][] O = {{1,1},{1,1}};
    private static int[][] Z = {{1,1,0},{0,1,1}};
    private static int[][] L = {{1,0,0},{1,0,0},{1,1,1}};
    private static int[][] T = {{1,1,1}, {0,1,0},{0,1,0}};
    private static int[][] I = {{1,1,1}};
    private static int[][] S = {{0,1,1}, {1,1,0}};
    private static int[][][] shapes = {O,Z,L,T,I,S};
    private static int COL = 15;
    private static int ROW = 10;
    private static int[][] board = new int[ROW][COL];
    private static int pieceRow = 0;
    private static int pieceCol = COL/2;
    private static int[][] currentPiece;
    private Random random;
    private static Scanner scanner;

    public TetrisClone(){
        random = new Random();
        scanner = new Scanner(System.in);
    }


    public void startGame(){
        boolean state = true;
        spawnPiece();
        while (state){
            printShape();
            System.out.println("Enter A for left, D for right, S for down");
            char direction = scanner.next().charAt(0);
            switch (direction){
                case 'A' -> move(-1);
                case 'D' -> move(1);
                case 'S' -> moveDown();
            }
        }

    }

    private void printShape(){
        System.out.println("pr");
        int[][] display = new int[ROW][COL];
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COL; j++)
                display[i][j] = board[i][j];
        }

        for (int i = 0; i < currentPiece.length; i++){
            for (int j = 0; j < currentPiece[0].length; j++){
                if (currentPiece[i][j] == 1){
                    display[pieceRow + i][pieceCol+j] = 1;
                }

            }
        }

        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COL; j++){
                char dis = display[i][j] == 1 ? '#' : '.';
                System.out.print(dis+" ");
            }
            System.out.println();
        }
    }

    private void spawnPiece(){
        int number = 4 ;
        int[][] randomPiece = shapes[number];
        System.out.println(number);
        System.out.println(canMove(randomPiece,0,COL/2));
        if (!canMove(randomPiece,0,COL/2)){
            System.out.println("GameOver");
            System.out.close();
            return;
        }
        currentPiece = randomPiece;
        pieceRow = 0;
        pieceCol = COL/2;
    }

    private boolean canMove(int[][] piece, int row, int col){
        for (int i = 0; i < piece.length; i++){
            for (int j = 0; j < piece[0].length; j++){
                if (piece[i][j] == 1){
                    int newRow = row + i;
                    int newCol = col + j;
                    if (newRow < 0 || newRow >= ROW || newCol < 0 || newCol >= COL || board[newRow][newCol] == 1)
                        return false;
                }
            }
        }
        return true;
    }

    private void moveDown(){
        if (!canMove(currentPiece, pieceRow+1,pieceCol)){
            for (int i = 0; i < currentPiece.length; i++){
                for (int j = 0; j < currentPiece[0].length; j++){
                    if (currentPiece[i][j] == 1){
                        board[pieceRow + i][pieceCol+j] = 1;
                    }
                }
            }
            clearRow();
            spawnPiece();
            return;
        }
        pieceRow++;
    }

    private void move(int direction){
        if (canMove(currentPiece, pieceRow, pieceCol + direction))
            pieceCol += direction;
    }

    private void clearRow(){
        for (int i = 0; i < ROW; i++){
            boolean rowFull = true;
            for (int j = 0; j < COL; j++){
                if (board[i][j] != 1){
                    rowFull = false;
                    break;
                }
            }
            if (rowFull){
                for (int jj = i; jj > 0; jj--){
                    board[jj] = board[jj-1].clone();
                }
            }
        }
    }

    public static void main(String[] args) {
        TetrisClone clone = new TetrisClone();
        clone.startGame();
    }
}
