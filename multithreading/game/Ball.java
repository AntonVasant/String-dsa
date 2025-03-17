package multithreading.game;

public class Ball {

    protected int pos_x;
    protected int pos_y;
    protected int dx;
    protected int dy;


    public Ball(int pos_x, int pos_y, int dx, int dy) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.dx = dx;
        this.dy = dy;
    }

    public void move(){
        pos_x += dx;
        pos_y += dy;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
