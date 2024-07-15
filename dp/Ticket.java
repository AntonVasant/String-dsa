package dp;

import java.util.HashSet;
import java.util.Set;

public class Ticket {
    public int minCostTickets(int[] days, int[] costs) {
        Set<Integer> set  = new HashSet<>();
        for (int num : days)
            set.add(num);
        int[] dp = new int[days[days.length-1]+1];
        return helper(1,dp,costs,set);
    }


    private int helper(int days,int[] dp,int[] cost,Set<Integer> set){
        if (days >= dp.length) return 0;
        if (dp[days] > 0) return dp[days];
        if (!set.contains(days))
            return dp[days] = helper(days+1,dp,cost,set);
        int one = helper(days+1,dp,cost,set) + cost[0];
        int two = helper(days+7,dp,cost,set) + cost[1];
        int three = helper(days+30,dp,cost,set) + cost[2];
        return dp[days] = Math.min(Math.min(one,two),three);
    }

}
