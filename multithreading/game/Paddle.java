package multithreading.game;

import java.util.Scanner;

public class Paddle implements Runnable{

    protected int width;
    protected int pos_y;
    protected int pos_x;
    Scanner scanner;

    public Paddle(int width, int pos_y, int pos_x) {
        this.width = width;
        this.pos_y = pos_y;
        this.pos_x = pos_x;
        scanner = new Scanner(System.in);
    }

    public void move(int direction, int screenHeight){
        if (pos_x + width + direction < screenHeight){
            pos_x += direction;
        }
        else throw new IllegalStateException("cant move");
    }

    @Override
    public void run() {
        while (true){
            char input = scanner.next().charAt(0);
            if (input == 'E')
                move(-1,20);
            else if (input == 'D')
                move(1,20);
        }
    }
}
