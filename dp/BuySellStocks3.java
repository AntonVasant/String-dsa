package dp;

public class BuySellStocks3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp =  new int[n+1][2][3];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 3; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(prices,1,0,dp,n,2);
    }
    private int helper(int[]array,int buy,int index,int[][][] dp,int n,int cap){
        if(index == array.length || cap == 0) return 0;
        if(dp[index][buy][cap] != -1) return dp[index][buy][cap];
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-array[index] + helper(array,0,index+1,dp,n,cap),helper(array,1,index+1,dp,n,cap));
        }else profit = Math.max(array[index] + helper(array,1,index+1,dp,n,cap-1),helper(array,0,index+1,dp,n,cap));
        return dp[index][buy][cap] = profit;
    }
}
