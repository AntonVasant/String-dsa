package twopointer;

import java.util.Arrays;

public class MinimumPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n/2; i++){
            int cur = nums[i] + nums[n-1-i];
            ans = Math.max(cur,ans);
        }
        return ans;
    }
}
