package array;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n*(n+1)/2;
        int current = 0;
        for(int num : nums)
            current += num;
        return total-current;
    }
}
