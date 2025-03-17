package gfg;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class RemoveAdjacentDuplicate {
    String rremove(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else stack.push(c);
        }
        StringBuilder res = new StringBuilder();
        for (char c : stack)
            res.append(c);
        return res.toString();
    }

    public static int firstRepeated(int[] arr) {
        int minIndex = -1;
        for (int i = 0; i < arr.length; i++){
            int index = Math.abs(arr[i]-1);
            if (arr[index] < 0){
                if (minIndex == -1 || i < minIndex)
                    minIndex = i+1;
            }
            arr[i] = -arr[i];
        }
        return minIndex;
    }


    public static boolean find3Numbers(int arr[], int n, int x) {
        Arrays.sort(arr);
        for (int i = 0; i < n-2; i++){
                int j = i+1;
                int k = n-1;
                while (j < k){
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum == x) return true;
                else if (sum > x) {
                    k--;
                }
                else j++;
            }
        }
        return false;
    }


    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == '1'){
                    ans++;
                    helper(grid,i,j);
                }
            }
        }
        return ans;
    }

    private void helper(char[][] grid,int i,int j){
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        helper(grid, i+1, j);
        helper(grid, i-1, j);
        helper(grid, i, j-1);
        helper(grid, i, j+1);
    }
}
