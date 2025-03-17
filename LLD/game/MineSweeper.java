package LLD.game;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    static char[][] board;
    static boolean[][] revealed;
    static boolean[][] mines;
    Scanner scanner;
    public MineSweeper(int a){
        this.scanner = new Scanner(System.in);
        board = new char[a][a];
        revealed = new boolean[a][a];
        mines = new boolean[a][a];
        initializeBoard(a);
        placeMines(a,10);
        play();
    }

   public void play(){
        while (true){
            print();
            System.out.println("Enter the row number");
            int row = scanner.nextInt();
            System.out.println("Enter the col");
            int col = scanner.nextInt();
            if (row < 0 || col < 0 || row >= board.length || col >= board.length){
                System.out.println("invalid move");
                continue;
            }
            if (mines[row][col]){
                System.out.println("you have entered a mine ,Game over");
                printMine();
                break;
            }
            revealCell(row,col);
        }
    }


    void revealCell(int row,int col){
        if (row < 0 || col < 0 || col >= 10 || row >= 10 || revealed[row][col])
            return;

        revealed[row][col] = true;
        int count = countAdjacentCells(row,col);
        if (count > 0){
            char c = (char) count;
            board[row][col] = c;
        }
        else {
            board[row][col] = ' ';
            for (int i = -1; i < 2; i++){
                for (int j = -1; j < 2; j++){
                    int x = row+i;
                    int y = col+j;
                    if (x >= 0 && x < board.length && y >= 0 && y < board.length)
                        revealCell(x,y);
                }
            }
        }
    }

    private int countAdjacentCells(int row,int col){
        int count = 0;
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
               int newX = row + i;
               int newY =  col + j;
               if (newX >= 0 && newY >= 0 && newX < 10 && newY < 10 && mines[newX][newY]) count++;
            }
        }
        return count;
    }

    void placeMines(int a,int num){
        Random random = new Random();
        while (num > 0){
            int row = random.nextInt(a);
            int col = random.nextInt(a);
            mines[row][col] = true;
            num--;
        }
    }
    void initializeBoard(int a){
        for (int i = 0; i < a; i++){
            for (int j = 0; j < a; j++){
                board[i][j] = '-';
            }
        }
    }

    private void printMine(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length;j++){
                if (mines[i][j]){
                    System.out.print("X ");
                }else System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private void print(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (revealed[i][j])
                    System.out.print(" ");
                else System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] a){
        MineSweeper mineSweeper = new MineSweeper(10);

    }
}
