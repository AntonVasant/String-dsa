package twopointer;

public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int len = nums.length;
        int maximum = 0;
        while(right < len){
            if(nums[right] == 0) zeroCount++;

            while(zeroCount > k){
                if(nums[left] == 0) zeroCount--;
                left++;
            }
            maximum = Math.max(maximum,right-left+1);
            right++;
        }
        return maximum;
    }/*Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.*/
}
