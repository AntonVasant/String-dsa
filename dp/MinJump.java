package dp;

import java.util.Arrays;

public class MinJump {
    static int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,0,dp);
    }


    private static int helper(int[] arr,int index, int[] dp){
        int n = arr.length;
        if (index >= n) return 0;
        if (dp[index] != -1) return dp[index];
        if (arr[index] == 0) return dp[index] = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int jump = 1; jump < arr[index] && jump + index < n; jump++){
            int current = helper(arr, index+ jump, dp);
            if (current != Integer.MAX_VALUE)
                min = Math.min(min,current+1);
        }
        return dp[index] = min;
    }

    public static void main(String[] args) {
        System.out.println(MinJump.minJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
    }
}
