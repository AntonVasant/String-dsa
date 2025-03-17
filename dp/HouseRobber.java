package dp;

import java.util.Arrays;

public class HouseRobber {
    public static int robber(int[] array,int index){
        if (index == 0) return array[0];
        if (index < 0) return 0;
        int pick = array[index] + robber(array, index-2);
        int notPick = robber(array, index-1);
        return Math.max(pick,notPick);
    }

    public static int memoization(int[] array,int[] dp,int index){
        if (index == 0) return array[0];
        if (index < 0) return 0;
        if (dp[index] != -1) return dp[index];
        int pick = array[index] + robber(array, index-2);
        int notPick = robber(array, index-1);
        return dp[index] = Math.max(pick,notPick);
    }

    public static int tabulation(int[] array,int[] dp,int index){
        dp[0] = array[0];
        int pick = Integer.MIN_VALUE;
        for (int i = 1; i <= index; i++){
            if(i >1)
                pick = array[i] + dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }
        return dp[index];
    }

    public int rob2(int[] nums) {
        int index = nums.length;
        if(index == 1)  return nums[0];
        int[] dp = new int[index+1];
        Arrays.fill(dp, -1);
        int first = helper(nums,index-1,dp,1);
        Arrays.fill(dp, -1);

        int second = helper(nums,index-2,dp,0);
        return Math.max(first,second);
    }

    private int helper(int[] nums, int index, int[] dp,int start) {
        if(index == start) return nums[start];
        if(index < start) return 0;
        if(dp[index] != -1) return dp[index];
        int pick = nums[index] + helper(nums, index-2, dp,start);
        int nonPick = helper(nums, index-1, dp,start);
        return dp[index] = Math.max(pick, nonPick);
    }
}
