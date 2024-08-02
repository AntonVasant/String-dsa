package dp;

import java.util.*;

public class LongestDivisibleSubsets {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer>[] memo = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            memo[i] = new ArrayList<>();
        }
        List<Integer> bestSubset = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            memo[i].add(nums[i]);
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && memo[j].size() + 1 > memo[i].size()) {
                    memo[i] = new ArrayList<>(memo[j]);
                    memo[i].add(nums[i]);
                }
            }
            if (memo[i].size() > bestSubset.size()) {
                bestSubset = memo[i];
            }
        }

        return bestSubset;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5,15,21,39,45};
        List<Integer> result = largestDivisibleSubset(nums);
        result.forEach(System.out::println);
    }
}