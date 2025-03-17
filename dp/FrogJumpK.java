package dp;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJumpK {
    public static int jump(int[] array,int index,int k){
        if(index == 0) return 0;
        int min = Integer.MAX_VALUE;
        int points = Integer.MAX_VALUE;
        for (int i = 1; i < k; i++){
            if (index - i >= 0)
                points = jump(array,index-i,k) + Math.abs(array[index] - array[index-i]);
            min = Math.min(min,points);
        }
        return min;
    }
    public static int memoization(int[] array,int[] dp,int index,int k){
        if (index == 0) return  0;
        if (dp[index] != -1) return dp[index];
        int min = Integer.MAX_VALUE;
        int points = Integer.MAX_VALUE;
        for (int i = 1; i < k; i++){
            if (index-i  >= 0)
                points = jump(array, index-i, k) + Math.abs(array[index] - array[index -i]);
            min = Math.min(points,min);
            dp[index] = min;
        }
        return dp[index];
    }

    //can frog reach the end stone if previous jump is k then try k + 1 and  k - 1 jumps for now 403
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        if (stones[1] != 1) return false;
        int n = stones.length;
        for (int num : stones)
            map.put(num, new HashSet<>());
        map.get(0).add(1);
        for (int stone : stones) {
            Set<Integer> set = map.get(stone);
            for (int jump : set) {
                int reach = jump + stone;
                if (reach == stones[n-1])
                    return true;
                if (map.containsKey(reach)) {
                    map.get(reach).add(jump);
                    map.get(reach).add(jump + 1);
                    if (jump - 1 > 0) map.get(reach).add(jump-1);
                }
            }
        }
        return false;
    }
}
