package binarysearch;

import java.util.Arrays;

public class KthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length-1]-nums[0];
        int mid;
        while (left < right){
            mid  = (left+right)/2;
            if (isValid(nums,mid,k)){
                right = mid;
            }
            else left = mid+1;
        }
        return left;
    }


    private boolean isValid(int[] nums,int mid,int k){
        int left = 0;
        int count = 0;
        for (int right = 1; right < nums.length; right++){
            while (nums[right] - nums[left] > mid) left++;
            count += right - left;
        }
        return count >= k;
    }
}
