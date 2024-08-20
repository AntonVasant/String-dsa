package array;

public class SortByParity {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int evenIndex = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[i];
                for (int j = i; j > evenIndex; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[evenIndex] = temp;
                evenIndex++;
            }
        }
        return nums;
    }
}
