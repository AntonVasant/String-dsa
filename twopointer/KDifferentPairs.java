package twopointer;

import java.util.HashSet;
import java.util.Set;

public class KDifferentPairs {
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);
        int count = 0;
        for (int n : nums){
            if (set.contains(n+k)){
                count++;
                set.remove(k+n);
            }
        }
        return count;
    }
}
