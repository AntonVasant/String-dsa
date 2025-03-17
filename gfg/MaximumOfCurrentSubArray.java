package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class MaximumOfCurrentSubArray {
    public static void maximumOfCurrent(int[] arr, int k){
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n-k+1];
        for (int i = 0; i < n; i++){
            if (i %k == 0)
                left[i] = arr[i];
            else left[i] = Math.max(arr[i],left[i-1]);
        }
        for (int i = n-1; i >= 0; i--){
            if ( i == n-1 || (i+1) % k == 0){
                right[i] = arr[i];
            }
            else right[i] = Math.max(right[i+1],arr[i]);
        }
        for (int i = 0; i < ans.length; i++){
            ans[i] = Math.max(right[i],left[i+k-1]);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        System.out.println(Arrays.toString(ans));
    }

    public static void main(String[] args) {
        maximumOfCurrent(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6},3);
    }
}
