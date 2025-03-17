package days;


import java.util.*;

public class TwentySeven {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long max = 0;
        int left= 0;
        long ans = 0;
        int n = nums.length;
        for (int right = 0; right < n; right++){
            max += nums[right];

            while (!set.add(nums[right])){
                set.remove(nums[left]);
                max -= nums[left];
                left++;
            }

            if (right - left + 1 == k) {
                ans = Math.max(ans, max);
                max -= nums[left];
                set.remove(nums[left++]);
            }
            set.add(nums[right]);
        }
        return ans;
    }
    public int takeCharacters(String s, int k) {
        int[] freq = new int[3];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        int left = 0;
        int min = Integer.MAX_VALUE;
        if (Math.min(freq[0], Math.min(freq[1], freq[2])) < k)
            return -1;
        int n = s.length();
        for (int right = 0; right < n; right++){
            System.out.println(Arrays.toString(freq));
            freq[s.charAt(right) - 'a']--;

            while (Math.min(freq[0], Math.min(freq[1], freq[2])) < k){
                freq[s.charAt(left++) - 'a']++;
            }
            min = Math.min(min, n - (right - left+1));
        }
        return min;
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int[][] grid = new int[m][n];

        for (int[] arr : guards){
            int i = arr[0];
            int j = arr[1];
            grid[i][j] = 1;
        }

        for (int[] arr : walls){
            int i = arr[0];
            int j = arr[1];
            grid[i][j] = 2;
        }

        for (int[] guard : guards)

            for (int[] directions : dir){
                int x = guard[0] + directions[0];
                int y = guard[1] + directions[1];

                while (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] != 1 && grid[x][y] != 2){
                    grid[x][y] = 3;
                    x += directions[0];
                    y += directions[1];
                }
            }


        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0)
                    ans++;
            }
        }
        return ans;
    }
    public long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        long sum = 0;
        int negCount = 0;
        for (int[] ints : matrix)
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] < 0)
                    negCount++;
                int ab = Math.abs(ints[j]);
                min = Math.min(min, ab);
                sum += ab;
            }
        if(negCount%2==0)
            return sum;
        return sum - 2L *min;
    }
    public int[] getModifiedArray(int n, int[][] updates) {
        int[] ans = new int[n];
        for (int[] arr : updates){
            int start = arr[0];
            int end = arr[1];
            int value = arr[2];
            ans[start] += value;
            if (end + 1 < n)
                ans[end+1] -= value;
        }

        for (int i = 1; i < n; i++)
            ans[i] += ans[i-1];
        return ans;
    }
    public boolean canSplit(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0) return false;
        int target = sum/2;
        int n = arr.length;
        Boolean[] dp = new Boolean[n];
        return found(arr, target,0,dp);
    }
    private boolean found(int[] arr, int target,int index, Boolean[] dp) {
        if (target == 0)
            return true;
        if (index == arr.length)
            return false;
        if (dp[index] != null) return dp[index];
        boolean res = found(arr, target - arr[index], index + 1, dp) || found(arr, target, index + 1, dp);
        return dp[index] = res;
    }


    public static void main(String[] args) {
        TwentySeven seven = new TwentySeven();
        System.out.println(seven.takeCharacters("aabaaaacaabc",2));
    }
}
