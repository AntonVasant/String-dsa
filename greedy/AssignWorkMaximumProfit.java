package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class AssignWorkMaximumProfit {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = worker.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++){
            pairs[i][0] = difficulty[i];
            pairs[i][1] = profit[i];
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int[] maxProfit = new int[n];
        maxProfit[0] = pairs[0][1];
        for (int i = 1; i < n; i++){
            maxProfit[i] = Math.max(maxProfit[i-1],pairs[i][1]);
        }
        int profits = 0;
        for (int workers : worker){
            int left = 0;
            int right = n-1;
            int mid;
            while (left <= right){
                mid = (left + right)/2;
                if (workers >= pairs[mid][0])
                    left = mid+1;
                else  right = mid -1;
            }
            if (right > 0) profits += maxProfit[right-1];
        }
        return profits;
    }
}
