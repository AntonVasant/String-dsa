package binarysearch;

public class SearchRotatedSorted2 {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[low] && nums[mid] == nums[high]){
                low = low + 1;
                high = high - 1;
                continue;
            }
            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target <= nums[mid]){
                    high = mid - 1;
                }else low = mid + 1;
            }
            if(nums[high] >= nums[mid]){
                if(target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else high = mid - 1;
            }
        }
        return false;
    }
}
