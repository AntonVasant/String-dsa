package array;

public class MinumumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        int low=0;
        int high = nums.length-1;
        int mid;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] >= nums[low]){
                min = Math.min(nums[low],min);
                low = mid+1;
            }
            else if(nums[mid] < nums[high]){
                min = Math.min(nums[mid],min);
                high = mid-1;
            }
        }
        return min;
    }
}

//find out the sorted half and narrow down the array with low and high