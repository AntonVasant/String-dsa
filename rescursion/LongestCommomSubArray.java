package rescursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommomSubArray {
    public static int findLength(int[] nums1, int[] nums2) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(nums1, nums2, 0, 0, 0, memo);
    }

    private static int helper(int[] nums1, int[] nums2, int i, int j, int count, Map<String, Integer> memo) {
        if (i == nums1.length || j == nums2.length) {
            return count;
        }

        String key = i + "," + j + "," + count;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int currentCount = count;
        if (nums1[i] == nums2[j]) {
            currentCount = helper(nums1, nums2, i + 1, j + 1, count + 1, memo);
        }

        int skipNums1 = helper(nums1, nums2, i + 1, j, 0, memo); // Reset count when skipping
        int skipNums2 = helper(nums1, nums2, i, j + 1, 0, memo); // Reset count when skipping

        int maxLength = Math.max(currentCount, Math.max(skipNums1, skipNums2));
        memo.put(key, maxLength);
        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println(findLength(new int[]{3,5,2,6,7,22,7,5,8,9}, new int[]{6,7,22,4,1,8,7,0,4}));
    }

    }