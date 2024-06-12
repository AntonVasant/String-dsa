package dp;

public class FrogJumpK {
    public static int jump(int[] array,int index,int k){
        if(index == 0) return 0;
        int min = Integer.MAX_VALUE;
        int points = Integer.MAX_VALUE;
        for (int i = 1; i < k; i++){
            if (index - i >= 0)
                points = jump(array,index-i,k) + Math.abs(array[index] - array[index-i]);
            min = Math.min(min,points);
        }
        return min;
    }
    public static int memoization(int[] array,int[] dp,int index,int k){
        if (index == 0) return  0;
        if (dp[index] != -1) return dp[index];
        int min = Integer.MAX_VALUE;
        int points = Integer.MAX_VALUE;
        for (int i = 1; i < k; i++){
            if (index-i  >= 0)
                points = jump(array, index-i, k) + Math.abs(array[index] - array[index -i]);
            min = Math.min(points,min);
            dp[index] = min;
        }
        return dp[index];
    }

    public static int tabulation(int[] array,int[] dp,int index,int k){
        dp[0] = 0;
        int jump = Integer.MAX_VALUE;
        for (int i = 1; i <= index; i++){
            int min = Integer.MAX_VALUE;
            for (int j = 1; j < k; j++){
                if (i-j >= 0)
                    jump = dp[i-j] + Math.abs(array[i] - array[i-j]);
                min = Math.min(min,jump);
            }
            dp[i] = min;
        }
       return dp[index];
    }
}
