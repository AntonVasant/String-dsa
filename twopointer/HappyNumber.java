package twopointer;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 0){
            int d = helper(n);
            if (set.contains(d)) return false;
            set.add(d);
            System.out.println(d);
            if (d == 1) return true;
            n = d;
        }
        return false;
    }

    private int helper(int n){
        int ans = 0;
        while (n > 0){
            int digit = n%10;
            ans += digit*digit;
            n/= 10;
        }
        return ans;
    }
}
