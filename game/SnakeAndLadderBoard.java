package game;

public class SnakeAndLadderBoard {

    public static void main(String[] args) {
        int[] board = new int[100]; // 1 to 100 cells
        initializeBoard(board);
        printBoard(board);
    }

    public static void initializeBoard(int[] board) {
        // Ladders
        board[3] = 1;  // Ladder from 4 to 14
        board[20] = 1; // Ladder from 21 to 38
        board[56] = 1; // Ladder from 57 to 77

        // Snakes
        board[16] = -1; // Snake from 17 to 7
        board[48] = -1; // Snake from 49 to 26
        board[88] = -1; // Snake from 89 to 24
    }

    // Print the board in reverse order (from 100 to 1)
    public static void printBoard(int[] board) {
        for (int row = 9; row >= 0; row--) {
            for (int col = 0; col < 10; col++) {
                int cell = row * 10 + col;

                // Print numbers with Snakes and Ladders
                if (board[cell] == 1) {
                    System.out.printf("| L%-2d ", cell + 1);
                } else if (board[cell] == -1) {
                    System.out.printf("| S%-2d ", cell + 1);
                } else {
                    System.out.printf("| %-3d ", cell + 1);
                }
            }
            System.out.println("|");
            System.out.println("-----------------------------------------------------------");
        }
    }
}

