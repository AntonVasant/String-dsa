package gfg;

import java.util.Arrays;

public class MinimumHeights {

    static int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n <= 1) return 0;
        Arrays.sort(arr);
        int minDiff = arr[n-1] - arr[0];
        int min;
        int max;
        for (int i = 1; i < n; i++){
            min = Math.min(arr[0]+k, arr[i] - k);
            max = Math.max(arr[n-1]-k, arr[i-1]-k);
            minDiff = Math.min(minDiff,max-min);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        System.out.println(MinimumHeights.getMinDiff(new int[]{3, 9, 12, 16, 20}, 3));
    }
}
