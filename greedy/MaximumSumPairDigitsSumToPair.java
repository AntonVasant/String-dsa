package greedy;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumPairDigitsSumToPair {
    public int maximumSum(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = -1;
        for (int num : nums){
            int sum = getSum(num);
            if (map.containsKey(sum)){
                ans = Math.max(ans,map.getOrDefault(num,0)+num);
            }
            map.put(num,map.getOrDefault(sum,0)+num);
        }
        return ans;
    }

    private int getSum(int num){
        int n = 0;
        while (num > 0){
            int digit = num%10;
            n += digit;
            num /= 10;
        }
        return n;
    }
}
