package dp;

import java.util.Arrays;
import java.util.List;

public class MinimumJump {
    public static int minJumps(int[] arr, int n) {
        if(n == 1) return 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int result = helper(arr, dp, 0, n - 1);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int helper(int[] array, int[] dp, int index, int n) {
        if (index == n) return 0;
        if (index > n || array[index] == 0) return Integer.MAX_VALUE;

        if (dp[index] != -1) return dp[index];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= array[index]; i++) {
            int jump = helper(array, dp, index + i, n);
            if (jump != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + jump);
            }
        }

        dp[index] = min;
        return dp[index];
    }

    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        int minDifference = arr[n-1] - arr[0];
        int minHeight;
        int maxHeight;
        for (int i = 1; i < n; i++){
            maxHeight = Math.max(arr[n-1] - k, arr[i] + k);
            minHeight = Math.min(arr[0] + k, arr[i] - k);

            minDifference = Math.min(minDifference, maxHeight - minHeight);
        }
        return minDifference;
    }

    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        double ans = 0;
        int currentCapacity = 0;
        while (currentCapacity < capacity){
            double ratio = 0;
            int index = -1;

            for (int i = 0; i < val.size(); i++){
                if (wt.get(i) > 0){
                    double currentRatio = (double) val.get(i) /wt.get(i);
                    if (currentRatio > ratio){
                        ratio = currentRatio;
                        index = i;
                    }
                }
            }

            if (index == -1) break;
            if (currentCapacity + wt.get(index) <= capacity){
                currentCapacity += wt.get(index);
                ans += val.get(index);
                wt.set(index,0);
            }
            else {
                int remaining = capacity - currentCapacity;
                ans += (double) val.get(index) * (double) remaining / wt.get(index);
                break;
            }
        }
        return ans;
    }


//    public Node addOne(Node head) {
//        // code here.
//
//        int carry = findCarry(head);
//        if (carry > 0){
//            Node nxt = new Node(carry);
//            nxt.next = head;
//            head = nxt;
//        }
//
//        return head;
//    }
//
//
//    private int findCarry(Node head){
//        if (head == null) return 1;
//
//        int carry = findCarry(head.next);
//
//        int sum = head.data + carry;
//
//        head.data = sum %10;
//
//        return sum / 10;
//    }


    public String multiplyStrings(String s1,String s2)
    {
        if (s1.startsWith("0") || s2.startsWith("0"))
            return "0";
        StringBuilder builder = new StringBuilder();
        int n = s1.length();
        int m = s2.length();
        int[] result = new int[n+m];
        for (int i = n - 1; i >= 0; i--){
            for (int j = m - 1; j >= 0; j--){
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] = sum / 10;
            }
        }
        for (int num : result){
            if (!(builder.isEmpty()) && num == 0)
                builder.append(num);
        }
        return builder.toString();
    }


    public static int findPages(int[] arr, int k) {
        int max = Arrays.stream(arr).sum();
        int min = Integer.MIN_VALUE;
        int ans = 0;
        for (int n : arr)
            min = Math.max(min, n);
        while (min < max){
            int mid = (min + max)/2;
            if (isValid(arr,k,mid)){
                ans = mid;
                min = mid + 1;
            }
            else max = mid - 1;
        }
        return ans;
    }

    private static boolean isValid(int[] arr,int k, int max){
        int total = 1;
        int current = 0;
        for (int num : arr){
            if (current + num > max){
                total++;
                current = num;
                if (total > k) return false;
            }
            else  current += num;
        }
        return total <= k;
    }


    int longestIncreasingPath(int[][] matrix, int n, int m) {
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                ans = Math.max(ans, findPath(matrix,i,j,-1,row,col));
            }
        }
        return ans;
    }

    private int findPath(int[][] mat, int i, int j, int prev,int n, int m){
        if (prev != -1 && i < 0 || j < 0 || i >= n || j >= m || mat[i][j] == -1 || mat[i][j] <= prev)
            return 0;

        int temp = mat[i][j];
        mat[i][j] = -1;
        int up = findPath(mat,i-1,j,temp,n,m);
        int down = findPath(mat,i+1,j,temp,n,m);
        int left = findPath(mat,i,j+1,temp,n,m);
        int right = findPath(mat,i,j-1,temp,n,m);
        mat[i][j] = temp;
        return Math.max(right, Math.max(left, Math.max(up,down))) + 1;
    }
}
