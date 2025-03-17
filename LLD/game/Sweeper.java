package LLD.game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sweeper{
    char[][] board;
    boolean[][] mines;
    boolean[][] revealed;
    Scanner scanner;


    public Sweeper(int n){
        this.board = new char[n][n];
        this.mines = new boolean[n][n];
        this.revealed = new boolean[n][n];
        this.scanner = new Scanner(System.in);
        initializeBoard();
        placeMine(n);
        play();
    }

    private void play(){
        for (boolean[] arr : mines){
            System.out.println(Arrays.toString(arr));
        }
        while (true){
            print();
            System.out.println("Enter the row");
            int row = scanner.nextInt();
            System.out.println("Enter the col");
            int col = scanner.nextInt();
            if (mines[row][col]){
                System.out.println("game over");
                printMine();
                break;
            }
            reveal(row,col);
        }

    }


    private void reveal(int row, int col){
        if (row < 0 || col < 0 || col >= board[0].length || col >= board.length || revealed[row][col])
            return;
        int count = countAdjacent(row,col);
        revealed[row][col] = true;
        board[row][col] = ' ';
        if (count > 0) board[row][col] = (char) count;
        else{
            for (int i = -1; i < 2; i++){
                for (int j = -1; j < 2; j++){
                    if (i >= 0 &&  j >= 0 && j < board[0].length && i < board.length)
                        reveal(i + row,j + col);
                }
            }
        }
    }

    private int countAdjacent(int row,int col){
        int num = 0;
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if (i + row  >= 0 &&  j + col >= 0 && j + col < board[0].length &&
                        i + row < board.length && mines[i + row][j + col])
                    num++;
            }
        }
        return num;
    }


    private void initializeBoard(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                board[i][j] = '-';
            }
        }
    }

    private void placeMine(int n){
        Random random = new Random();
        for (int i = 0; i < n; i++){
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            mines[a][b] = true;
        }
    }


    private void printMine(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if (mines[i][j])
                    board[i][j] = 'X';
                else if (revealed[i][j]) {
                    board[i][j] = ' ';
                }
                else board[i][j] = '-';
            }
            }
        print();
    }

    private void print(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Sweeper sweeper = new Sweeper(10);
    }
}