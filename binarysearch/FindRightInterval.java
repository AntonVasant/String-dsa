package binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        int[][] starts = new int[n][2];

        // Store the start time and the original index of each interval
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }

        // Sort the starts array by the start times
        Arrays.sort(starts, Comparator.comparingInt(a -> a[0]));

        // For each interval, use binary search to find the right interval
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int idx = binarySearch(starts, end);
            result[i] = (idx == -1) ? -1 : starts[idx][1];
        }

        return result;
    }

    // Binary search to find the smallest start time >= target
    private int binarySearch(int[][] starts, int target) {
        int left = 0, right = starts.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (starts[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return starts[left][0] >= target ? left : -1;
    }
}
