package greedy;

import java.util.HashSet;
import java.util.Set;

public class NextHappyNumber {
    static int nextHappy(int N){
        int num = N+1;
        while (!isHappy(num))
            num++;
        return num;
    }

    private static boolean isHappy(int n){
        Set<Integer> set = new HashSet<>();

        while (n != 1  && !set.contains(n)){
            set.add(n);
            n = digit(n);
        }
        return n==1;
    }


    private static int digit(int n){
        int ans = 0;
        while (n > 0){
            int digit = n%10;
            digit = digit *digit;
            ans += digit;
            n /= 10;
        }
        return ans;
    }
}
/*
For a given non-negative integer N, find the next smallest Happy Number. A number is called Happy if it leads to 1 after a sequence
of steps. Wherein at each step the number is replaced by the sum of squares of its digits that is, if we start with Happy Number
and keep replacing it with sum of squares of its digits, we reach 1 at some point.
 */