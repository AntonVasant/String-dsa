package array;

import java.util.HashMap;
import java.util.Map;

public class ArrayPairDivisibleByK {
    public long countPairs(int[] nums, int k) {
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ;i < nums.length; i++){
            int gcd = gcd(nums[i],k);
            if (gcd * nums[i] %k == 0){
                ans += map.get(gcd);
            }
            map.put(gcd,map.getOrDefault(gcd,0)+1);
        }
        return ans;
    }


    private int gcd(int n,int m){
        int min = Math.min(n,m);
        for (int i = min; i >0 ; i--){
            if (i %m == 0 && i % n == 0) return i;
        }
        return 0;
    }
}
