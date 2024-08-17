package greedy;

import java.util.Map;

public class MinimumMoveToMakeZigZac {
    public int movesToMakeZigzag(int[] nums) {
        int one = helper(nums,true);
        int two = helper(nums,false);
        return Math.min(one,two);
    }

    private int helper(int[] nums,boolean increase){
        int count = 0;
        int n = nums.length;
        int prev = nums[0];
        for (int i = 1; i < n; i++){
            if (increase){
                if (nums[i] < prev)
                    count += prev - nums[i] +1;
            }else {
                if (nums[i] > prev){
                    count += nums[i] - prev +1;
                }
            }
            increase = !increase;
            prev = nums[i];
        }
        return count;
    }
}
