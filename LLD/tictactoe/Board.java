package LLD.tictactoe;

import java.util.*;

public class Board {
    int sizeOfBoard;
    char[][] board;
    static int[] colsSum;
    static int[] rowSum;
    static int diagonalSum;
    static int reverseDiagonal;
    Queue<Player> nextTurn;
    Scanner input;


    public Board(Player player1,Player player2,int n){
        this.board = new char[2*n-1][2*n-1];
        initializeBoard(board);
        nextTurn = new LinkedList<>();
        nextTurn.offer(player1);
        nextTurn.offer(player2);
        colsSum = new int[3];
        rowSum = new int[3];
        input = new Scanner(System.in);
        play();
    }

    void play(){
        int count = 0;
        while (true) {
            print();
            Player currentPlayer = nextTurn.poll();
            System.out.println(currentPlayer.getPlayerName()+ " Enter your next Move");
            int[] moves = getMove();
            board[moves[0]][moves[1]] = currentPlayer.playerMove;
            count++;
            int res = placeMove(currentPlayer.getPlayerId(), moves[2], moves[3]);
            if (count > board.length * board[0].length || res != 0){
                System.out.println("Player "+currentPlayer.getPlayerName()+" won");
                break;
            }
            nextTurn.offer(currentPlayer);
        }
    }

   private int placeMove(int player, int row, int  col){
        board[row][col] = player == -1 ? 'O' : 'X';
        rowSum[row] += player;
        colsSum[col] += player;
        if (row == col)
            diagonalSum++;
        if (row == col - row)
            reverseDiagonal++;
        if (Math.abs(rowSum[row]) == 3 || Math.abs(colsSum[col]) == 3
                || Math.abs(diagonalSum) == 3 || Math.abs(reverseDiagonal) == 3)
            return player;
        return 0;
   }

    private int[] getMove(){
        System.out.println("Enter the row number");
        int r = 0;
        int c = 0;
        int row = input.nextInt();
        r = row;
       if (row == 1) row = 0;
       else if (row == 3) row = 4;
        System.out.println("Enter the col number");
        int col = input.nextInt();
        c = col;
        if (col == 1) col = 0;
        else if (col == 3) col = 4;
        while (!validateMove(row,col)){
            System.out.println("the move is not valid,enter the correct move");
            getMove();
        }
        return new int[]{row,col,r,c};
    }

    private boolean validateMove(int row, int col){
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    private void initializeBoard(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i % 2 == 0 && j % 2 != 0) {
                    board[i][j] = '|';
                }
                if (i % 2 != 0 && j % 2 != 0) {
                    board[i][j] = '+';
                }
                if (i % 2 != 0 && j % 2 == 0) {
                    board[i][j] = '-';
                }
            }
        }
    }

    void print(){
         for (char[] c : board){
             for (char ch : c)
                 System.out.print(ch);
             System.out.println();
         }
    }


}
