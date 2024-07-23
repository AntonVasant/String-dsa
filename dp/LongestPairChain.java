package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class LongestPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                 if (o1[0] == o2[0])
                     return o1[1] - o2[1];
                 return o1[0] - o2[0];
            }
        });
        return helper(pairs,new int[]{-1,-1},0);
    }
    private int helper(int[][] pairs,int[] prev,int index){
        if (index >= pairs.length) return 0;
        int take = 0;
        if (prev[0] == -1 || prev[0] < pairs[index][0] && prev[0] < pairs[index][1]
                && prev[1] < pairs[index][1] && prev[1] < pairs[index][0]){
            take  = 1 + helper(pairs, pairs[index], index+1);
        }
        int non = helper(pairs, prev, index+1);
        return Math.max(take,non);
    }
}
