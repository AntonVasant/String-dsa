package gfg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumNumber {
    String printLargest(String[] arr) {
        quickSort(arr,0,arr.length-1);
        if (arr[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String s: arr)
            sb.append(s);
        return sb.toString();
    }

    private void quickSort(String[] arr, int low, int high){
        if (low < high){
            int next = nextIndex(arr, low, high);
            quickSort(arr,low, next-1);
            quickSort(arr,next+1, high);
        }
    }

    private int nextIndex(String[] arr, int left, int right){
        int i = left - 1;
        String pivot  = arr[right];
        for (int j = left; j < right; j++){
            if (isSwap(arr[j],pivot)){
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        String temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return i+1;
    }

    private boolean isSwap(String a, String b){
        String option1 = a+b;
        String option2 = b+a;
        return option1.compareTo(option2) > 0;
    }

    public int orangesRotting(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int goodOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++){
            for (int j= 0; j < col; j++){
                if (mat[i][j] == 1)
                    goodOranges++;
                else if (mat[i][j] == 2)
                    queue.offer(new int[]{i,j});
            }
        }
        if (goodOranges == 0) return 0;
        return helper(mat,queue,goodOranges);
    }

    private int helper(int[][] mat,Queue<int[]> queue, int goodOranges){
        int row = mat.length;
        int col = mat[0].length;
        int[][] dir = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        int ans = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] current = queue.poll();
                for (int[] arr : dir){
                    int newX = current[0] + arr[0];
                    int newY = current[1] + arr[1];
                    if (newX >= 0 && newX < row && newY >= 0 && newY < col){
                        if (mat[newX][newY] == 1){
                            queue.offer(new int[]{newX, newY});
                            goodOranges--;
                            mat[newX][newY] = 2;
                        }
                    }
                }
            }
            if (goodOranges <= 0) return ans;
            ans++;
        }
        return -1;
    }

    long countPS(String str){
        final int MOD = 1000000007;
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;
        for (int len = 2; len <= n; len++){
            for (int i = 0; i <= n - len; i++){
                int j = i + len - 1;
                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = (dp[i+1][j] + dp[i][j-1] + 1) % MOD;
                else dp[i][j] = (dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1] + MOD) % MOD;
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        MaximumNumber number = new MaximumNumber();
        number.printLargest(new String[]{"3", "30", "34", "5", "9"});
    }
}
