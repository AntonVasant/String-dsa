package dp;

import java.util.Map;

public class MinimumCostToConvertString {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long ans = 0;
        for (int i = 0; i < target.length(); i++){
            if (source.charAt(i) != target.charAt(i)){
                ans += helper(source.charAt(i),target.charAt(i),original,changed,cost);
                System.out.println(ans);
            }
        }
        return ans;
    }

    private long helper(char source,char destination,char[] original,char[] changed,int[] cost){
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < original.length; i++){
            if (original[i] == source){
                if (changed[i] == destination){
                    ans = Math.min(ans,cost[i]);
                }
            }
        }
        return ans;
    }
}
