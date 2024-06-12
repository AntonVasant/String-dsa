package dp;

public class HouseRobber {
    public static int robber(int[] array,int index){
        if (index == 0) return array[0];
        if (index < 0) return 0;
        int pick = array[index] + robber(array, index-2);
        int notPick = robber(array, index-1);
        return Math.max(pick,notPick);
    }

    public static int memoization(int[] array,int[] dp,int index){
        if (index == 0) return array[0];
        if (index < 0) return 0;
        if (dp[index] != -1) return dp[index];
        int pick = array[index] + robber(array, index-2);
        int notPick = robber(array, index-1);
        return dp[index] = Math.max(pick,notPick);
    }

    public static int tabulation(int[] array,int[] dp,int index){
        dp[0] = array[0];
        int pick = Integer.MIN_VALUE;
        for (int i = 1; i <= index; i++){
            if(i >1)
                pick = array[i] + dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }
        return dp[index];
    }
}
