package dp;

public class SellStockWithCoolDown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i = 0; i< n; i++){
            for(int j = 0; j < 2; j++){
                dp[i][j] = -1;
            }
        }
        return helper(prices,0,1,dp,n);
    }

    private int helper(int[] array,int index,int buy,int[][] dp,int n){
        if(index >= n) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-array[index] + helper(array,index+1,0,dp,n),helper(array,index+1,1,dp,n));
        }else profit = Math.max(array[index] + helper(array,index+2,1,dp,n),helper(array,index+1,0,dp,n));
        return dp[index][buy] = profit;
    }
}
