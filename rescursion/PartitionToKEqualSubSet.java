package rescursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitionToKEqualSubSet {
    public static boolean partition(int[] array,int k){
        int sum = Arrays.stream(array).sum();
        int target = sum/k;
        Arrays.sort(array);
        boolean[] used= new boolean[array.length];
        Map<String,Boolean> map = new HashMap<>();
        return helper(array,0,used,k,map,0,target);
    }

    private static boolean helper(int[] array, int start, boolean[] used, int k,
                                  Map<String, Boolean> memo, int current, int target) {
        if (k == 0) return true;
        if (current == target) {
            return helper(array, 0, used, k - 1, memo, 0, target);
        }
        String key = Arrays.toString(used) + start + "," + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        for (int i = start; i < array.length; i++) {
            if (!used[i] && current + array[i] <= target) {
                used[i] = true;
                if (helper(array, i + 1, used, k, memo, current + array[i], target)) {
                    memo.put(key, true);
                    return true;
                }
                used[i] = false;
            }
        }
        memo.put(key, false);
        return false;
    }
}
