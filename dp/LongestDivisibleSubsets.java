package dp;

import java.util.*;

public class LongestDivisibleSubsets {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);  // Sort the array
        int n = nums.length;

        int[] dp = new int[n];  // Stores the size of the largest subset ending at index i
        int[] prev = new int[n]; // Stores the previous index in the subset
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxSize = 1, lastIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                lastIndex = i;
            }
        }

        // Reconstruct the subset
        List<Integer> result = new ArrayList<>();
        for (int i = lastIndex; i >= 0; i = prev[i]) {
            result.add(nums[i]);
            if (prev[i] == -1) break;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5,15,21,39,45};
        List<Integer> result = largestDivisibleSubset(nums);
        result.forEach(System.out::println);
    }
}