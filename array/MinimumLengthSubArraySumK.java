package array;

public class MinimumLengthSubArraySumK {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int ans = 0;
        int current = 0;
        for (int right = 0; right < nums.length; right++) {
            current += nums[right];
            while (current >= target) {
                int subarrayLength = right - left + 1;
                if (ans == 0 || subarrayLength < ans) {
                    ans = subarrayLength;
                }
                current -= nums[left];
                left++;
            }
        }
        return ans;
    }
}
