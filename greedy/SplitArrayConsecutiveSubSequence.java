package greedy;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayConsecutiveSubSequence {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        Map<Integer,Integer> subsequenceMap = new HashMap<>();
        for (int n : nums)
            freq.put(n,freq.getOrDefault(n,0)+1);
        for (int n : nums){
            if (freq.get(n) == 0) continue;
            if (subsequenceMap.getOrDefault(n-1,0) > 0){
                subsequenceMap.put(n-1,subsequenceMap.get(n-1)-1);
                subsequenceMap.put(n,subsequenceMap.getOrDefault(n,0)+1);
            } else if (freq.getOrDefault(n+1,0) > 0 && freq.getOrDefault(n+2,0) > 0) {
                freq.put(n+1,freq.getOrDefault(n+1,0)-1);
                freq.put(n+2,freq.getOrDefault(n+2,0)-1);
                subsequenceMap.put(n+2,subsequenceMap.getOrDefault(n+2,0)+1);
            }else return false;
            freq.put(n,freq.get(n)-1);
        }
        return true;
    }
}

/*
Input: nums = [1,2,3,3,4,5]
Output: true
Explanation: nums can be split into the following subsequences:
[1,2,3,3,4,5] --> 1, 2, 3
[1,2,3,3,4,5] --> 3, 4, 5
 */