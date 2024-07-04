package binarysearch;

public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        int mid=0;
        while(low <= high){
            mid = (low + high)/2;
            int count = 0;
            for(int num : nums){
                if(num <= mid) count++;
            }
            if(count > mid) high = mid;
            else low = mid + 1;
            if(high == mid && low == mid) return mid;
        }
        return low;
    }
}
