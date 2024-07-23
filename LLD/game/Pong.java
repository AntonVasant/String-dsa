package LLD.game;
import java.util.Scanner;

public class Pong {
    private static final int WIDTH = 30;
    private static final int HEIGHT = 15;
    private static int ballX = WIDTH / 2;
    private static int ballY = HEIGHT / 2;
    private static int ballDirX = 1;
    private static int ballDirY = 1;
    private static int leftPaddleY = HEIGHT / 2 - 2;
    private static int rightPaddleY = HEIGHT / 2 - 2;
    private static final int PADDLE_HEIGHT = 4;
    private static final int PADDLE_X_LEFT = 1;
    private static final int PADDLE_X_RIGHT = WIDTH - 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            clearConsole();
            drawGame();
            updateBallPosition();
            handleInput(scanner);
            try {
                Thread.sleep(100); // Control game speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void drawGame() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (x == ballX && y == ballY) {
                    System.out.print("O"); // Draw the ball
                } else if (x == PADDLE_X_LEFT && y >= leftPaddleY && y < leftPaddleY + PADDLE_HEIGHT) {
                    System.out.print("|"); // Draw the left paddle
                } else if (x == PADDLE_X_RIGHT && y >= rightPaddleY && y < rightPaddleY + PADDLE_HEIGHT) {
                    System.out.print("|"); // Draw the right paddle
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void updateBallPosition() {
        ballX += ballDirX;
        ballY += ballDirY;

        // Handle ball collision with top and bottom walls
        if (ballY <= 0 || ballY >= HEIGHT - 1) {
            ballDirY = -ballDirY; // Reverse direction in Y axis
        }

        // Handle ball collision with paddles
        if (ballX == PADDLE_X_LEFT + 1 && ballY >= leftPaddleY && ballY < leftPaddleY + PADDLE_HEIGHT) {
            ballDirX = -ballDirX; // Reverse direction in X axis
        }
        if (ballX == PADDLE_X_RIGHT - 1 && ballY >= rightPaddleY && ballY < rightPaddleY + PADDLE_HEIGHT) {
            ballDirX = -ballDirX; // Reverse direction in X axis
        }

        // Handle ball going out of bounds (left or right)
        if (ballX <= 0 || ballX >= WIDTH - 1) {
            System.out.println("Game Over!");
            System.exit(0);
        }
    }
    private static void handleInput(Scanner scanner) {
        if (scanner.hasNext()) {
            String input = scanner.next();
            // Left paddle controls
            if (input.equalsIgnoreCase("w") && leftPaddleY > 0) {
                leftPaddleY--; // Move paddle up
            }
            if (input.equalsIgnoreCase("s") && leftPaddleY < HEIGHT - PADDLE_HEIGHT) {
                leftPaddleY++; // Move paddle down
            }
            // Right paddle controls
            if (input.equalsIgnoreCase("i") && rightPaddleY > 0) {
                rightPaddleY--; // Move paddle up
            }
            if (input.equalsIgnoreCase("k") && rightPaddleY < HEIGHT - PADDLE_HEIGHT) {
                rightPaddleY++; // Move paddle down
            }
        }
    }
}

