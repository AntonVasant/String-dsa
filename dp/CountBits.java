package dp;

import java.util.Arrays;

public class CountBits {
    public static void count(int n) {
        int[] res = new int[n + 1];
        int offset = 1;
        for (int i = 1; i <= n; i++){
            if (i == offset*i){
                offset = i;
            }
            res[i] = 1+res[i-offset];
        }
        System.out.println(Arrays.toString(res));
    }
}
