package dp;

import java.util.HashMap;
import java.util.Map;

public class NumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Map<String, int[]> memo = new HashMap<>();
        int[] result = findLIS(nums, -1, 0, memo);
        return result[1];
    }
    private int[] findLIS(int[] nums, int prevIndex, int currentIndex, Map<String, int[]> memo) {
        if (currentIndex == nums.length) return new int[]{0, 1};
        String key = prevIndex + "," + currentIndex;
        if (memo.containsKey(key)) return memo.get(key);
        int[] exclude = findLIS(nums, prevIndex, currentIndex + 1, memo);
        int[] include = {0, 0};
        if (prevIndex == -1 || nums[currentIndex] > nums[prevIndex]) {
            include = findLIS(nums, currentIndex, currentIndex + 1, memo);
            include[0]++;
        }
        int maxLength = Math.max(include[0], exclude[0]);
        int count = 0;
        if (maxLength == include[0]) count += include[1];
        if (maxLength == exclude[0]) count += exclude[1];
        memo.put(key, new int[]{maxLength, count});
        return memo.get(key);
    }
}
