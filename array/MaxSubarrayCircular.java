package array;

public class MaxSubarrayCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        int total = 0;
        for (int i = 1; i < nums.length; i++){
            int n = nums[i];
            currentMax = Math.max(n,currentMax+n);
            max = Math.max(max,currentMax);
            currentMin = Math.min(n,currentMin+n);
            min = Math.min(min,currentMin);
            total += n;
        }
        total += nums[0];
        if (max < 0) return max;
        return Math.max(max,total-min);
    }
}
