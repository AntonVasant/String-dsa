package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumRemovalNonOverlppingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] < prev)
                count++;
            else prev = intervals[i][1];
        }
        return count;
    }
}
