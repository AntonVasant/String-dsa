package greedy;

import java.util.Arrays;
import java.util.Map;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] right = new int[n];
        int[] left = new int[n];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < n; i++){
            right[i] = ratings[i] > ratings[i-1] ? right[i-1]+1 : 1;
        }
        for (int i = n-2; i >=0; i--){
            left[i] = ratings[i] > ratings[i+1] ? left[i+1]+1 : 1;
        }
        int total = 0;
        for (int i =0; i < n; i++){
            total += Math.max(right[i] ,left[i]);
        }
        return total;
    }
}
