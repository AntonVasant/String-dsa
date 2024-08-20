package string;

import java.util.Arrays;
import java.util.List;

public class TimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            String s = timePoints.get(i);
            int time = Integer.parseInt(s.substring(0,2))*60 + Integer.parseInt(s.substring(3));
            arr[i] = time;
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++){
            min = Math.min(min,arr[i] - arr[i-1]);
        }
        min = Math.min(min,(1440 -arr[n-1]) + arr[0]);
        return min;
    }
}
