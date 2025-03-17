package prefixsum;

import java.util.Random;

public class RandomePointsInRectangle {

    int total;
    int[][] rectangles;
    Random random;
    int[] prefix;

    public RandomePointsInRectangle(int[][] rects) {
        total = 0;
        rectangles = rects;
        random = new Random();
        prefix = new int[rects.length];
        for (int i = 0;  i < rects.length; i++){
            int[] cur = rects[i];
            int area  = (cur[2] - cur[0] + 1) * (cur[3] - cur[1]  + 1);
            total += area;
            prefix[i] = total;

        }
    }

    public int[] pick() {
        int target = random.nextInt(total)+ 1;
        int index = binary(target);
        int[] re = rectangles[index];
        int x1 = re[0];
        int y1 = re[1];
        int x2 = re[2];
        int y2 = re[3];
        int x = x1 + random.nextInt(x2 - x1 + 1);
        int y = y1 + random.nextInt(y2 - y1 + 1);
        return new int[]{x,y};
    }

    private int binary(int num){
        int left = 0;
        int right = prefix.length-1;
        while (left < right){
            int mid = (left + right) /2;
            if (prefix[mid] < num) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
