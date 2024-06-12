package dp;

public class SellStockWithFee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i = 0; i< n; i++){
            for(int j = 0; j < 2; j++){
                dp[i][j] = -1;
            }
        }
        return helper(prices,0,1,dp,n,fee);
    }

    private int helper(int[] array,int index,int buy,int[][] dp,int n,int fee){
        if(index >= n) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-array[index] + helper(array,index+1,0,dp,n,fee),helper(array,index+1,1,dp,n,fee));
        }else profit = Math.max(array[index]-fee + helper(array,index+1,1,dp,n,fee),helper(array,index+1,0,dp,n,fee));
        return dp[index][buy] = profit;
    }
}
