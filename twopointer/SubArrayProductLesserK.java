package twopointer;

import java.util.HashMap;
import java.util.Map;

public class SubArrayProductLesserK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int count = 0;
        int left = 0;
        int product = 1;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
