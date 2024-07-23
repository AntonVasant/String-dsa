package LLD.game;

import java.util.Scanner;

public class BrickBreaker {
        static final int WIDTH = 20;
        static final int HEIGHT = 10;
        static final char EMPTY = ' ';
        static final char BRICK = '0';
        static final char BALL = 'O';
        static final char PADDLE = '=';
        static final char BORDER = '*';

        static char[][] board = new char[HEIGHT][WIDTH];
        static int ballX = WIDTH / 2, ballY = HEIGHT - 3;
        static int paddleX = WIDTH / 2 - 2;
        static int ballDirX = 1, ballDirY = -1;

        public static void main(String[] args) {
            initBoard();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                printBoard();
                System.out.println("Move paddle (a: left, d: right, q: quit): ");
                char move = scanner.next().charAt(0);

                if (move == 'q') break;

                movePaddle(move);
                moveBall();

                if (isGameOver()) {
                    System.out.println("Game Over!");
                    break;
                }
            }
            scanner.close();
        }

        static void initBoard() {
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    if (i == 0 || i == HEIGHT - 1 || j == 0 || j == WIDTH - 1) {
                        board[i][j] = BORDER;
                    } else if (i < 3) {
                        board[i][j] = BRICK;
                    } else {
                        board[i][j] = EMPTY;
                    }
                }
            }
            board[ballY][ballX] = BALL;
            for (int i = 0; i < 5; i++) {
                board[HEIGHT - 2][paddleX + i] = PADDLE;
            }
        }

        static void printBoard() {
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }

        static void movePaddle(char move) {
            if (move == 'a' && paddleX > 1) {
                board[HEIGHT - 2][paddleX + 4] = EMPTY;
                paddleX--;
                board[HEIGHT - 2][paddleX] = PADDLE;
            } else if (move == 'd' && paddleX < WIDTH - 6) {
                board[HEIGHT - 2][paddleX] = EMPTY;
                paddleX++;
                board[HEIGHT - 2][paddleX + 4] = PADDLE;
            }
        }

        static void moveBall() {
            board[ballY][ballX] = EMPTY;
            ballX += ballDirX;
            ballY += ballDirY;

            if (board[ballY][ballX] == BRICK) {
                ballDirY = -ballDirY;
                board[ballY][ballX] = EMPTY;
            } else if (ballX == 0 || ballX == WIDTH - 1) {
                ballDirX = -ballDirX;
            } else if (ballY == 0) {
                ballDirY = -ballDirY;
            } else if (ballY == HEIGHT - 2 && ballX >= paddleX && ballX < paddleX + 5) {
                ballDirY = -ballDirY;
            }

            board[ballY][ballX] = BALL;
        }

        static boolean isGameOver() {
            return ballY == HEIGHT - 1;
        }
    }
