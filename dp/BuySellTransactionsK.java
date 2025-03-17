package dp;

public class BuySellTransactionsK {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][k+1][2];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= k; j++){
                for(int l = 0; l < 2; l++){
                    dp[i][j][l] = -1;
                }
            }
        }
        return helper(prices,0,k,1,dp);
    }

    private int helper(int[] array,int index,int k,int buy,int[][][] dp){
        if(index == array.length || k == 0) return 0;
        if(dp[index][k][buy] != -1) return dp[index][k][buy];
        int profit;
        if(buy == 1){
            profit = Math.max(-array[index]
                    + helper(array,index+1,k,0,dp),helper(array,index+1,k,1,dp));
        }
        else profit = Math.max(array[index]
                + helper(array,index+1,k-1,1,dp),helper(array,index+1,k,0,dp));
        return dp[index][k][buy] = profit;
    }
}
