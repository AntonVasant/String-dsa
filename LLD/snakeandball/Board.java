package LLD.snakeandball;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Board {
    private char[][] board;
    private Queue<Node> food;
    private Queue<Node> snake;
    private Scanner scanner;

    public Board(int n){
        this.board = new char[n][n];
        this.food = new LinkedList<>();
        this.snake = new LinkedList<>();
        this.scanner = new Scanner(System.in);
        snake.offer(new Node(0, 0));
        board[0][0] = '.';
        food.offer(new Node(4, 7));
        food.offer(new Node(7, 5));
        food.offer(new Node(8, 4));
        food.offer(new Node(4, 6));
        food.offer(new Node(2, 4));
        displayFood();
        playGame();
    }

    void playGame(){
        int row = 0;
        int col = 0;
        while (true){
            System.out.println("Enter your move (U/D/L/R):");
            char move = scanner.next().charAt(0);
            switch (move) {
                case 'U':
                    row--;
                    break;
                case 'D':
                    row++;
                    break;
                case 'L':
                    col--;
                    break;
                case 'R':
                    col++;
                    break;
                default:
                    System.out.println("Invalid move. Game over.");
                    return;
            }
            if (!snakeMove(row, col)) {
                break;
            }
        }
    }

    boolean snakeMove(int row, int col){
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '.'){
            System.out.println("Game over. You failed.");
            return false;
        }
        if (board[row][col] == 'X'){
            eatBall(row, col);
            food.poll();
            displayFood();
        } else {
            Node tail = snake.poll();
            board[tail.getRow()][tail.getCol()] = '\0';
        }
        snake.offer(new Node(row, col));
        board[row][col] = '.';
        print();
        if (food.isEmpty()) {
            System.out.println("Game over. You have won.");
            return false;
        }
        return true;
    }

    private void eatBall(int row, int col){
        board[row][col] = '.';
        snake.offer(new Node(row, col));
    }

    void displayFood(){
         Node node = food.peek();
         board[node.getRow()][node.getCol()] = 'X';
    }

    void print(){
        for (char[] c : board){
            for (int i = 0; i < board[0].length; i++){
                System.out.print(c[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Board(10);
    }
}
