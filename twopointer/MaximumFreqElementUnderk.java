package twopointer;

import java.util.Arrays;

public class MaximumFreqElementUnderk {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int length = 0;
        int total = 0;
        int windowSum = 0;
        int n = nums.length;
        int ans = 0;
        while(right < n){
            windowSum += nums[right];
            length = right - left + 1;
            total = nums[right] * length;
            while(total - windowSum > k){
                windowSum -= nums[left];
                left++;
                length = right - left +1;
                if(right < n)
                    total = nums[right] * length;
            }
            ans = Math.max(ans,length);
            right++;
        }
        return ans;
    }
}
