package LLD.snakeandball;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class
        GamePlay {
    char[][] board;
    Queue<Node> snake;
    Queue<Node> food;
    Scanner scanner;


    GamePlay(int n){
        this.board = new char[n][n];
        this.food = new LinkedList<>();
        this.snake = new LinkedList<>();
        this.scanner = new Scanner(System.in);
        snake.offer(new Node(0,0));
        food.offer(new Node(5,7));
        food.offer(new Node(3,6));
        food.offer(new Node(8,5));
        food.offer(new Node(2,4));
        displayFood();
        board[0][0] = '.';
        print();
        play();
    }

    void play(){
        int row = 0;
        int col = 0;
        while (true){
            System.out.println("Enter the move U/D/L/R");
            char move = scanner.next().charAt(0);
            switch (move){
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
                    System.out.println("invalid move"); break;
            }
            if (food.isEmpty()){
                System.out.println("You won");
                return;
            }
            if (!snakeMove(row,col)) break;
            print();
        }
    }

    void displayFood(){
        if (food.isEmpty()) {
            System.out.println("you win");
            return;
        }
        Node node = food.poll();
        board[node.getRow()][node.getCol()] = 'X';
    }

    boolean snakeMove(int row,int col){
        if (row < 0 || col < 0 || row >= board.length || col >= board.length || board[row][col] == '.'){
            System.out.println("Game over you lost");
            return false;
        }
        if (board[row][col] == 'X')
            eatFood(row, col);
        else {
            Node node = snake.poll();
            board[node.getRow()][node.getCol()] = '\0';
            snake.offer(new Node(row, col));
            board[row][col] = '.';
        }
        return true;
    }

    void eatFood(int row,int col){
        board[row][col] = '.';
        snake.offer(new Node(row, col));
        displayFood();
    }

    void print(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] a){
        GamePlay gamePlay = new GamePlay(10);
    }
}
