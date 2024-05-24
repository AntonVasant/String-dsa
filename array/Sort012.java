package array;

public class Sort012 {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while (mid <= high){
            if(nums[mid] == 0){
                swap(nums,mid,low);
                low++;
                mid++;
            }else if (nums[mid] == 1) mid++;
            else {
                swap(nums,mid,high);
                high--;
            }
        }
    }
    private void swap(int[] array,int first,int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
