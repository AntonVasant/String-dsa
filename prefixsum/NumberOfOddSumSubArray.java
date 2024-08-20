package prefixsum;

import java.awt.*;

public class NumberOfOddSumSubArray {
    public int numOfSubarrays(int[] arr) {
        int ans = 0;
        int mod = 1000000007;
        int prefix = 0;
        int odd = 0;
        int even = 1;
        for (int num : arr){
            prefix += num;
            if (prefix%2 == 0){
                ans += odd;
                even++;
            }
            else {
                ans += even;
                odd++;
            }
            ans %= mod;
        }
        return ans;
    }
}
