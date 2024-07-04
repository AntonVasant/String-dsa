package LLD.tictactoe;

import java.util.*;

public class Board {
    int sizeOfBoard;
    char[][] board;
    Queue<Player> nextTurn;
    Scanner input;


    public Board(Player player1,Player player2,int n){
        this.board = new char[2*n-1][2*n-1];
        initializeBoard(board);
        this.nextTurn = new LinkedList<>();
        nextTurn.offer(player1);
        nextTurn.offer(player2);
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
            if (count > board.length * board[0].length || checkGameOver(currentPlayer,moves[0],moves[1])) break;
            nextTurn.offer(currentPlayer);
        }
    }

    private boolean checkGameOver(Player player,int row,int col){
        String over = "";
        for (int i = 0; i < 3; i++)
            over += String.valueOf(player.getPlayerMove());
        String straight = "";
        String down = "";
        String diag = "";
        for (int i = 0; i < board.length; i++){
            straight += String.valueOf(board[row][i]);
            down += String.valueOf(board[i][col]);
            if (row == col)
                diag += String.valueOf(board[i][i]);
        }
        System.out.println(over+" over");
        System.out.println(straight+" str");
        if (over.equals(straight) || over.equals(diag) || over.equals(down)){
            System.out.println("Congrats "+player.getPlayerName()+" you have won the game");
            return true;
        }
        return false;
    }

    private int[] getMove(){
        System.out.println("Enter the row number");
        int row = input.nextInt();
        System.out.println("Enter the col number");
        int col = input.nextInt();
        while (!validateMove(row,col)){
            System.out.println("the move is not valid,enter the correct move");
            getMove();
        }
        return new int[]{row,col};
    }

    private boolean validateMove(int row, int col){
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;
        return true;
    }

    private void initializeBoard(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (i%2 == 0 && j%2 != 0){
                    board[i][j] = '|';
                }
                if (i%2 != 0 && j%2 != 0){
                    board[i][j] = '+';
                }
                if (i%2 != 0 && j%2 == 0){
                    board[i][j] = '-';
                }
            }
        }
        print();
    }

    void print(){
         for (char[] c : board){
             for (char ch : c)
                 System.out.print(ch);
             System.out.println();
         }
    }
}
