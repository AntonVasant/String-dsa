package greedy;

import java.util.Arrays;

public class MinimumNumberOfArrows {
        public int findMinArrowShots(int[][] points) {
            int count = 1;
            Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
            long mark = points[0][1];
            for (int i = 1; i < points.length; i++) {

                if (points[i][0] > mark) {
                    count++;
                    mark = points[i][1];
                }
            }
            return count;
        }
}
