package array;

public class MinimumSwapToGroup1 {
    public int minSwaps(int[] nums) {
        int total = 0;
        int n = nums.length;
        for (int num : nums)
            if (num == 1) total++;
        int window = 0;
        for (int i = 0; i < total; i++){
            if (nums[i] == 1) window++;
        }
        int max = window;
        for (int i = total; i < n + total; i++){
            if (nums[i%n] == 1) window++;
            if (nums[(i - total)%n] == 1)
                window--;
            max = Math.max(max,window);
        }
        return total - max;
    }
}
