package dp;

public class BuySellStocks2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp =  new int[n+1][2];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 2; j++){
                dp[i][j] = -1;
            }
        }
        return helper(prices,1,0,dp,n);
    }
    private int helper(int[]array,int buy,int index,int[][] dp,int n){
        if(index == array.length) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-array[index] + helper(array,0,index+1,dp,n),helper(array,1,index+1,dp,n));
        }else profit = Math.max(array[index] + helper(array,1,index+1,dp,n),helper(array,0,index+1,dp,n));
        return dp[index][buy] = profit;
    }
}
