package twopointer;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i >= 0 && nums[i] >= nums[i+1])
            i--;
        if (i >= 0){
            int j = nums.length-1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1, nums.length-1);
    }

    private void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void reverse(int[] array,int i,int j){
        while (i < j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}
