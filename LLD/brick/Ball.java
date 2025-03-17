package LLD.brick;

import java.util.HashSet;
import java.util.Set;

public class Ball {

    private int ballX;
    private int ballY;
    private int movingX;
    private int movingY;

    public Ball(int x, int y){
        ballX = x;
        ballY = y;
    }
    public int getBallX() {
        return ballX;
    }

    public void setBallX(int ballX) {
        this.ballX = ballX;
    }

    public int getBallY() {
        return ballY;
    }

    public void setBallY(int ballY) {
        this.ballY = ballY;
    }

    public int getMovingX() {
        return movingX;
    }

    public void setMovingX(int movingX) {
        this.movingX = movingX;
    }

    public int getMovingY() {
        return movingY;
    }

    public void setMovingY(int movingY) {
        this.movingY = movingY;
    }


}
