package LLD.game;
import java.util.Arrays;
import java.util.Scanner;

public class SlidingPuzzle {

    private static final int SIZE = 3;
    private int[][] board;
    private int emptyRow, emptyCol;

    public SlidingPuzzle() {
        board = new int[SIZE][SIZE];
        int count = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = count;
                count++;
            }
        }
        board[SIZE-1][SIZE-1] = 0; // The empty space is represented by 0
        emptyRow = SIZE-1;
        emptyCol = SIZE-1;
    }

    public void displayBoard() {
        for (int[] row : board) {
            for (int tile : row) {
                if (tile == 0) {
                    System.out.print("   ");
                } else {
                    System.out.printf("%2d ", tile);
                }
            }
            System.out.println();
        }
    }

    public boolean moveTile(int tile) {
        if (tile <= 0 || tile >= SIZE * SIZE) {
            return false;
        }

        // Find the tile position
        int tileRow = -1, tileCol = -1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == tile) {
                    tileRow = i;
                    tileCol = j;
                    break;
                }
            }
        }

        // Check if the tile can move to the empty space
        if (Math.abs(tileRow - emptyRow) + Math.abs(tileCol - emptyCol) == 1) {
            board[emptyRow][emptyCol] = tile;
            board[tileRow][tileCol] = 0;
            emptyRow = tileRow;
            emptyCol = tileCol;
            return true;
        }

        return false;
    }

    public boolean isSolved() {
        int count = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == SIZE-1 && j == SIZE-1) {
                    return board[i][j] == 0;
                }
                if (board[i][j] != count) {
                    return false;
                }
                count++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SlidingPuzzle puzzle = new SlidingPuzzle();
        Scanner scanner = new Scanner(System.in);

        while (!puzzle.isSolved()) {
            puzzle.displayBoard();
            System.out.println("Enter tile number to move (0 to exit): ");
            int tile = scanner.nextInt();
            if (tile == 0) {
                break;
            }
            if (!puzzle.moveTile(tile)) {
                System.out.println("Invalid move!");
            }
        }

        if (puzzle.isSolved()) {
            System.out.println("Congratulations! You solved the puzzle!");
        } else {
            System.out.println("Puzzle was not solved.");
        }
    }
}

