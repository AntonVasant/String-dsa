package binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class AssignWork {
    public static int assignWork(int[] difficulty,int[] profit,int[] workers){
        int totalProfit = 0;
        int n = difficulty.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++){
             pairs[i][0] = difficulty[i];
             pairs[i][1] = profit[i];
        }
        Arrays.sort(pairs,(a,b) -> Integer.compare(a[1],b[1]));
        for (int[] num : pairs)
            System.out.print(Arrays.toString(num)+" ");
         for (int worker : workers)
             totalProfit += assigning(pairs,worker);
        return totalProfit;
    }
    public static int assigning(int[][] pairs,int workerCapacity){
        int ans = 0;
        for(int i = pairs.length-1; i >= 0; i--){
            if (workerCapacity <= pairs[i][0]){
                ans = pairs[i][1];
                break;
            }
        }
        return ans;
    }

}
