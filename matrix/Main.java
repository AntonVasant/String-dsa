package matrix;
public class Main {
    public static void main(String a[]) {
        int[][] array = {{1, 0, 0, 0},
                         {1, 1, 0, 0}};
        int[][] pos = {{1,1},{1, 0}};
        BrickFall brickFall = new BrickFall();
        int[] n = brickFall.hitBricks(array, pos);
        for (int i : n)
            System.out.println(i);
    }
}
