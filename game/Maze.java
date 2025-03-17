package game;

import LLD.train.SeatType;

import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Maze {

    static char[][] board;
    static int ROW;
    static int COL;
    static int life;
    static int cROW;
    static int cCOL;
    Scanner scanner;
    Random random;

    public Maze(int row, int col, int life){
        board = new char[row][col];
        Maze.life = life;
        ROW = row;
        COL = col;
        random = new Random();
        scanner = new Scanner(System.in);
        placeObstacleAndTrap();
        start();
    }

    private void start(){
        while (true){
            printBoard();
            System.out.println("W - up, A - left, D - right,S - down");
            char choice = scanner.next().charAt(0);
            switch (choice){
                case 'W' -> moveVertical(-1);
                case 'S' -> moveVertical(1);
                case 'A' -> moveHorizontal(-1);
                case 'D' -> moveHorizontal(1);
            }
        }
    }

    private boolean checkGameState(){
        if (cROW == ROW -1 && cCOL == COL -1){
            System.out.println("You won");
            return false;
        }

        if (board[cROW][cCOL] == 'T'){
            if (life == 0){
                System.out.println("you fail");
                return false;
            }
            life--;
        }
        return true;
    }

    private void moveHorizontal(int num){
        if (cCOL+ num < COL && cCOL + num >= 0){
            board[cROW][cCOL] = '\0';
            cCOL += num;
            board[cROW][cCOL] = 'M';
        }
        if (!checkGameState()) System.exit(0);
    }

    private void moveVertical(int num){
        if (cROW+ num < COL && cROW + num >= 0){
            board[cROW][cCOL] = '\0';
            cROW += num;
            board[cROW][cCOL] = 'M';
        }
        if (!checkGameState()) System.exit(0);
    }

    private void printBoard(){
        for (char[] arr : board){
            for (int i = 0; i < ROW; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }

    private void placeObstacleAndTrap(){
        for (int i = 0; i < 10; i++){
            int r = random.nextInt(ROW);
            int c  = random.nextInt(COL);
            board[r][c] = '#';
        }

        for (int i = 0; i < 5; i++){
            int r = random.nextInt(ROW);
            int c  = random.nextInt(COL);
            board[r][c] = 'T';
        }
        board[0][0] = 'R';
    }


    public long maxSumWithK(long[] a, long n, long k){
        long[] max = new long[(int) (n)];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = Math.max(sum, sum + a[i]);
            max[i] = sum;
        }

        sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }

        long maximum = sum;

        for (int i = (int)k; i < n; i++) {
            sum += a[i] - a[i -(int) k];

            maximum = Math.max(maximum, sum);
            maximum = Math.max(maximum, maximum + max[i - (int) k]);
        }
        return maximum;
    }


    public static int hIndex(int[] citations) {
        int low = 0;
        int n = citations.length;
        int high = citations.length-1;
        while (low <= high){
            int mid = (low + high)/2;
            if (citations[mid] >= n - mid + 1)
                high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }


    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1,2,100}));

    }

}
