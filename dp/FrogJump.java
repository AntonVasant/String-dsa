package dp;

public class FrogJump {
    public static int jump(int[] array,int index){
        int two = Integer.MAX_VALUE;
        if(index == 0) return 0;
        int one = jump(array,index-1) + Math.abs(array[index] - array[index-1]);
        if (index > 1) two = Math.abs(array[index] - array[index-2]) + jump(array,index-2);
        return Math.min(one,two);
    }
    public static int memoization(int[] array,int[] dp,int index){
        int two = Integer.MAX_VALUE;
        if (index == 0) return 0;
        if (dp[index] != -1) return dp[index];
        int one = jump(array,index-1) + Math.abs(array[index] - array[index-1]);
        if (index > 1) two = Math.abs(array[index] - array[index-2]) + jump(array,index-2);
        return dp[index] = Math.min(one,two);
    }
    public static int tabulation(int[] array,int[] dp,int index){
        int two = Integer.MAX_VALUE;
        dp[0] = 0;

        for (int i = 1; i < array.length; i++){
            int one = dp[i-1] + Math.abs(array[i] - array[i-1]);
            if (i > 1) two = dp[i-2] + Math.abs(array[i] - array[i-2]);
            dp[i] = Math.min(one,two);
        }
        return dp[index];
    }
}
