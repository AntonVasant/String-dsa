package array;


import java.util.Arrays;

public class SquareCheck {
    public static void main(String[] args) {
        int x1 = 20, y1 = 10;
        int x2 = 10, y2 = 20;
        int x3 = 20, y3 = 20;
        int x4 = 10, y4 = 10;
        String result = isSquare(x1, y1, x2, y2, x3, y3, x4, y4) ? "Yes" : "No";
        System.out.println(result);
    }

    public static boolean isSquare(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int[] distances = new int[6];
        distances[0] = getSquaredDistance(x1, y1, x2, y2);
        distances[1] = getSquaredDistance(x1, y1, x3, y3);
        distances[2] = getSquaredDistance(x1, y1, x4, y4);
        distances[3] = getSquaredDistance(x2, y2, x3, y3);
        distances[4] = getSquaredDistance(x2, y2, x4, y4);
        distances[5] = getSquaredDistance(x3, y3, x4, y4);
        System.out.println(Arrays.toString(distances));
        Arrays.sort(distances);
        System.out.println(Arrays.toString(distances));
        return distances[0] > 0 && distances[0] == distances[1] && distances[1] == distances[2]
                && distances[2] == distances[3] && distances[4] == distances[5];
    }
    private static int getSquaredDistance(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}

