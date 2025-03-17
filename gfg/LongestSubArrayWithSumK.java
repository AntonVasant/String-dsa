package gfg;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static int lenOfLongSubarr(int A[], int N, int K) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < N; i++){
            sum += A[i];
            int current = sum - K;
            if (map.containsKey(current)){
                ans = Math.max(ans, i - map.get(current));
            }
            map.put(sum,i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lenOfLongSubarr(new int[]{-1,2,3}, 3, 6));
    }
}
