package array;

import java.util.*;

public class BuySellStocks {

    public static void zoho(int[] arr){
        int n = arr.length;
        int index = n - 1;
        for (int i = n-1; i >= 0; i--) {
            if (arr[i] < 0) {
                int number = arr[i];
                for (int j = i; j < index; j++){
                    arr[j] = arr[j+1];
                }
                arr[index--] = number;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void moveNumbers(int[] arr, Set<Integer> set) {
        int n = arr.length;
        int index = n-1;
        for (int i = n-1; i >= 0; i--) {
            if (set.contains(arr[i])) {
                int number = arr[i];
                for (int j = i; j < index; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[index--] = number;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public int celebrity(int[][] mat) {
        Stack<Integer> stack = new Stack<>();
        int n = mat.length;
        for (int i = 0; i < n; i++){
            stack.push(i);
        }

        while (stack.size() > 1){
            int first = stack.pop();
            int second = stack.pop();
            if (mat[first][second] == 1)
                stack.push(second);
            else stack.push(first);
        }

        if (stack.isEmpty())
            return -1;
        int celebrity = stack.pop();
        for (int i = 0; i < n; i++){
            if (i != celebrity){
                if (mat[i][celebrity] != 1 || mat[celebrity][i] == 1)
                    return -1;
            }
        }
        return celebrity;
    }
    static int maxArea(int[][] mat) {
        int m = mat[0].length;
        int ans = 0;
        int[] height = new int[m];
        for (int[] ints : mat) {
            for (int j = 0; j < m; j++) {
                height[j] = ints[j] == 0 ? 0 : height[j] + ints[j];
            }
            ans = Math.max(ans, calculateArea(height));
        }
        return ans;
    }
    private static int calculateArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++){
            int num = i  == n ? 0 : heights[i];
            while (!stack.isEmpty() && num < heights[stack.peek()]){
                int top = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek()-1;
                max = Math.max(max, top * width);
            }
            stack.push(i);
        }
        return max;
    }
    public static int largestSubmatrixWithZeroSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] temp = new int[m];
            for (int top = i; top < n; top++) {
                for (int j = 0; j < m; j++) {
                    temp[j] += mat[top][j]; // Convert the problem to a 1D zero-sum subarray
                }

                ans = Math.max(ans, findZeroSum(temp, top - i + 1)); // Fix height calculation
            }
        }
        return ans;
    }

    private static int findZeroSum(int[] arr, int height) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int max = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                int index = map.get(sum);
                max = Math.max(max, i - index);
            } else {
                map.put(sum, i); // Fix: Store first occurrence of sum
            }
        }

        return max * height; // Compute area
    }


    public int[] findRightInterval(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = intervals.length;
        int[] arr = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = intervals[i][0];

        for (int i = 0; i < n; i++)
            map.put(arr[i], i);

        Arrays.sort(arr);
        for (int i = 0; i < n; i++){
            int num = binarySearch(arr, intervals[i][1]);
            ans[i] = num == -1 ? -1 : map.get(arr[num]);
        }
        return ans;
    }


    private int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target){
                ans = mid;
                high = mid -1;
            }
            else low = mid + 1;
        }
        return ans;
    }

    int equalSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int current = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (current == sum)
                return i;
            current += arr[i];
            sum -= arr[i];
        }
        return -1;
    }

}
