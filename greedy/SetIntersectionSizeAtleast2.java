package greedy;

import java.util.Arrays;

public class SetIntersectionSizeAtleast2 {
    public int intersectionSizeTwo(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a,b) -> (a[1] == b[1]) ? b[0] - a[0] : a[1] - b[1]);
        int first = -1;
        int second = -2;
        for (int[] inter : intervals){
            if (inter[0] > second){
                count+= 2;
                second = inter[1];
                first = inter[1]-1;
            } else if (inter[0] > first) {
                count += 1;
                first = second;
                second = inter[1];
            }
        }
        return count;
    }
}
