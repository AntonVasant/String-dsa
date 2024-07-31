package array;

public class MaximumAverageArray1 {
    public double findMaxAverage(int[] nums, int k) {
        double ans = 0;
        double total = 0;
        for (int i = 0; i < k; i++){
            total += nums[i];
        }
        ans = total/k;
        for (int i = k; i < nums.length; i++){
            total -= nums[i-k];
            total+= nums[i];
            ans = Math.max(ans,total/k);
        }
        return ans;
    }
}
