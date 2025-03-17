package game;

import java.util.Scanner;

public class Tetris {
    static final int ROWS = 20;
    static final int COLS = 10;
    static int[][] board = new int[ROWS][COLS];
    static int[][] currentPiece;
    static int pieceRow = 0, pieceCol = COLS / 2 - 1;
    static final int[][] I = {{1, 1, 1, 1}};
    static final int[][] O = {{1, 1}, {1, 1}};
    static final int[][] T = {{0, 1, 0}, {1, 1, 1}};
    static final int[][] L = {{1, 0}, {1, 0}, {1, 1}};
    static final int[][] J = {{0, 1}, {0, 1}, {1, 1}};
    static final int[][] S = {{0, 1, 1}, {1, 1, 0}};
    static final int[][] Z = {{1, 1, 0}, {0, 1, 1}};
    static int[][][] pieces = {I, O, T, L, J, S, Z};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;
        spawnPiece();

        while (!gameOver) {
            printBoard();
            System.out.println("Move (W: Rotate, A: Left, D: Right, S: Down): ");
            char move = scanner.next().charAt(0);

            switch (move) {
                case 'W': rotatePiece(); break;
                case 'A': movePiece(-1); break;
                case 'D': movePiece(1); break;
                case 'S': gameOver = !movePieceDown(); break;
                default: System.out.println("Invalid input");
            }

            if (gameOver) {
                System.out.println("Game Over!");
            }
        }
        scanner.close();
    }


    static void spawnPiece() {
        int random = (int) (Math.random() * pieces.length);
        currentPiece = pieces[random];
        pieceRow = 0;
        pieceCol = COLS / 2 - 1;
        if (!canMove(pieceRow, pieceCol)) {
            System.out.println("Game Over!");
            System.exit(0);
        }
    }


    static void printBoard() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                boolean isPiece = false;
                for (int pr = 0; pr < currentPiece.length; pr++) {
                    for (int pc = 0; pc < currentPiece[0].length; pc++) {
                        if (currentPiece[pr][pc] == 1 && r == pieceRow + pr && c == pieceCol + pc) {
                            isPiece = true;
                            break;
                        }
                    }
                }
                System.out.print(isPiece ? "#" : board[r][c] == 1 ? "#" : ".");
            }
            System.out.println();
        }
    }



    static boolean movePieceDown() {
        if (!canMove(pieceRow + 1, pieceCol)) {
            for (int r = 0; r < currentPiece.length; r++) {
                for (int c = 0; c < currentPiece[0].length; c++) {
                    if (currentPiece[r][c] == 1)
                        board[pieceRow + r][pieceCol + c] = 1;
                }
            }
            clearRows();

            spawnPiece();

            return true;
        }

        pieceRow++;
        return true;
    }

    static void movePiece(int direction) {
        if (canMove(pieceRow, pieceCol + direction)) {
            pieceCol += direction;
        }
    }

    static void rotatePiece() {
        int rows = currentPiece[0].length;
        int cols = currentPiece.length;
        int[][] rotated = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                rotated[r][c] = currentPiece[cols - c - 1][r];
            }
        }

        if (canMove(pieceRow, pieceCol, rotated)) {
            currentPiece = rotated;
        }
    }


    static boolean canMove(int newRow, int newCol) {
        return canMove(newRow, newCol, currentPiece);
    }


    static boolean canMove(int newRow, int newCol, int[][] piece) {
        for (int r = 0; r < piece.length; r++) {
            for (int c = 0; c < piece[0].length; c++) {
                if (piece[r][c] == 1) {
                    int newR = newRow + r;
                    int newC = newCol + c;
                    if (newR < 0 || newR >= ROWS || newC < 0 || newC >= COLS || board[newR][newC] == 1)
                        return false;
                }
            }
        }
        return true;
    }


    static void clearRows() {
        for (int r = ROWS - 1; r >= 0; r--) {
            boolean fullRow = true;
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 0) {
                    fullRow = false;
                    break;
                }
            }
            if (fullRow) {
                for (int rr = r; rr > 0; rr--) {
                    board[rr] = board[rr - 1].clone();
                }

                board[0] = new int[COLS];
                r++;
            }
        }
    }
}
