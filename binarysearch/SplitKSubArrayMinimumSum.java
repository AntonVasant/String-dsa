package binarysearch;

public class SplitKSubArrayMinimumSum {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int total =0;
        for(int num : nums){
            if(num > max) max = num;
            total += num;
        }
        int low = max;
        int high = total;
        int mid;
        int ans =0;
        while(low <= high){
            mid = (low + high)/2;
            if(helper(nums,k,mid)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;

    }

    private boolean helper(int[] array,int k,int capacity){
        int subArrays = 1;
        int currentCapacity = 0;
        for(int num : array){
            if(currentCapacity + num > capacity){
                subArrays++;
                currentCapacity = num;
                if (subArrays > k) return false;
            } else currentCapacity += num;
        }
        return true;
    }


}
