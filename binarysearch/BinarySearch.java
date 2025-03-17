package binarysearch;

import java.util.Arrays;

public class BinarySearch {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 1;
        int high = n - 2;
        int mid;
        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1])
                return mid;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return -1;
    }


    //2563
    public long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int j = 1; j < n; j++){
            int x = lower - nums[j];
            int y = upper - nums[j];
            int count1 = lowerBound(nums, 0, j-1, x);
            int count2 = upperBound(nums, 0, j-1, y);
            res += (count2 - count1);
        }
        return res;
    }

    private int lowerBound(int[] arr, int low, int high, int x){
        if (arr[low] >= x) return low;
        if (arr[high] < x) return high + 1;
        while (low < high-1){
            int mid = (low + high)/2;
            if (arr[mid] >= x){
                high = mid;
            }
            else low = mid;
        }
        return high;
    }
    private int upperBound(int[] arr, int low, int high, int x){
        if (arr[low] > x) return low;
        if (arr[high] <= x) return high + 1;
        while (low < high-1){
            int mid = (low + high)/2;
            if (arr[mid] > x){
                high = mid;
            }
            else low = mid;
        }
        return high;
    }
}
