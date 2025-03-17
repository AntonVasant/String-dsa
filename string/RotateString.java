package string;

import linkedList.Node;

import java.util.*;

public class RotateString {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n-2][n-2];
        for (int i = 0; i < n-2; i++){
            for (int j = 0; j < n-2; j++){
                int max = Integer.MIN_VALUE;
                for (int k = i; k < i+3; k++){
                    for (int l = j; l < j + 3; l++){
                        max = Math.max(max,grid[k][l]);
                    }
                }
                ans[i][j] = max;
            }
        }

        return ans;
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[] prefix = new int[n];
        Arrays.sort(nums);
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i-1] + nums[i];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
            ans[i] = binarySearch(prefix,queries[i]);
        return ans;
    }


    private int binarySearch(int[] arr, int n){
        int low = 0;
        int high = arr.length-1;
        int ans = 0;
        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] <= n){
                ans = mid;
                low = mid+1;
            } else if (arr[mid] > n) {
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }


    static void reverseInGroups(ArrayList<Long> arr, int k) {
        int n = arr.size();
        int index = 0;
        while (index + k < n){
            reverseList(arr,index,index+k-1);
            index += k;
        }

        if (index < n-1)
            reverseList(arr,index,n-1);
    }

    private static void reverseList(ArrayList<Long> list, int start, int end){
        while (start < end){
            long temp = list.get(start);
            list.set(start,list.get(end));
            list.set(end,temp);
            start++;
            end--;
        }
    }

    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = mat[0].length;
        int upper = 0;
        int bottom = mat.length-1;
        while (left < right && upper < bottom) {
            for (int i = left; i <= right; i++) {
                list.add(mat[upper][i]);
            }
            upper++;
            for (int i = upper; i <= bottom; i++)
                list.add(mat[i][right]);
            right--;

            if (upper <= bottom) {
                for (int i = right; i >= left; i--)
                    list.add(mat[bottom][i]);
                bottom--;

            }
            if (left <= right) {
                for (int i = bottom; i >= upper; i--)
                    list.add(mat[i][left]);
                left++;
            }
        }
        return list;
    }


    static void rotate(int matrix[][]) {
        int row = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < cols; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]  = temp;
            }
        }

        for (int i = 0; i < row; i++){
            int left = 0;
            int right = cols-1;
            while (left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }


    void booleanMatrix(int[][] matrix)
    {
        int row = matrix.length;
        int cols = matrix[0].length;
        boolean isRow = false;
        boolean isCol = false;
        for (int[] ints : matrix) {
            if (ints[0] == 1) {
                isCol = true;
                break;
            }
        }

        for (int i = 0; i < cols; i++){
            if (matrix[0][i] == 1){
                isRow = true;
                break;
            }
        }

        for (int i = 1; i < row; i++){
            for (int j = 1; j < cols; j++){
                if (matrix[i][j] == 1){
                    matrix[0][i] = 1;
                    matrix[j][0] = 1;
                }
            }
        }

        for (int i = 0; i < row; i++){
            if (matrix[i][0] == 1){
                for (int j = 1; j < cols; j++)
                    matrix[i][j] = 1;
            }
        }

        for (int i = 0; i < cols; i++){
            if (matrix[0][i] == 1){
                for (int j = 1; j < row; j++)
                    matrix[j][i] = 1;
            }
        }
        if (isRow){
            for (int i = 0; i < cols; i++){
                matrix[0][i] = 1;
            }
        }

        if (isCol){
            for (int i = 0; i < row; i++)
                matrix[i][0] = 1;
        }
    }


    public void threeWayPartition(int[] array, int a, int b)
    {
        int i = 0;
        int n = array.length;
        int end = n-1;
        int start = 0;

        while (i < end){
            if (array[i] < a){
                int temp = array[i];
                array[i] = array[start];
                array[start] = temp;
                start++;
                i++;
            } else if (array[i] > b) {
                int temp = array[i];
                array[i] = array[end];
                array[end] = temp;
                end--;
            }
            else i++;
        }
    }

    public static long[] productExceptSelf(int arr[]) {
        int n = arr.length;
        long[] product = new long[n];
        long num = 1;
        for (int i = 1; i < n; i++){
            product[i] = num * arr[i-1];
            num *= arr[i-1];
        }
        num = 1;
        for (int i = n-2; i >= 0; i--){
            product[i] = num * arr[i+1];
            num *= arr[i+1];
        }
        return product;
    }


    int minDist(int arr[], int x, int y) {
        int lastX = -1;
        int lastY = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == x){
                lastX = i;
                if (lastY != -1){
                    ans = Math.min(ans,Math.abs(lastX - lastY));
                }
            } else if (arr[i] == y) {
                lastY = i;
                if (lastX != -1)
                    ans = Math.min(ans,Math.abs(lastX - lastY));
            }
        }
        return ans;
    }

    public int findKRotation(List<Integer> arr) {
        int left = 0;
        int n = arr.size();
        int right = arr.size()-1;
        while (left < right){
            int mid = (left + right)/2;
            if (mid > 0 && arr.get(mid) < arr.get(mid-1))
                return mid;
            else if (mid < n - 1 && arr.get(mid) > arr.get(mid+1))
                return mid+1;
            if (arr.get(mid) > arr.get(right))
                left = mid + 1;
            else right = mid - 1;
        }
        return 0;
    }

    public static int FindMaxSum(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return helper(arr,0,dp);
    }

    private static int helper(int[] arr, int index,int[] dp){
        if (index >= arr.length) return 0;
        if (dp[index] != -1) return dp[index];
        int take = arr[index] + helper(arr,index+2,dp);
        int no = helper(arr,index+1,dp);
        return dp[index] =  Math.max(take,no);
    }



    public List<String> findPermutation(String s) {
        List<String> list = new ArrayList<>();
        boolean[] used=  new boolean[s.length()];
        helper(list, s,used,new StringBuilder());
        System.out.println(list.size());
        return list;

    }

    private void helper(List<String> list, String s, boolean[] used,StringBuilder sb){
            if (sb.length() == s.length()){
                list.add(new String(sb));
                return;
        }

        for (int i = 0; i < used.length; i++){
            if (!used[i]){
                if (i > 0 && s.charAt(i) == s.charAt(i-1) && !used[i-1]) continue;
                sb.append(s.charAt(i));
                used[i] = true;
                helper(list,s,used,sb);
                used[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }

        }
    }

    int maxIndexDiff(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.min(left[i-1], arr[i]);
        right[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--)
            right[i] = Math.max(right[i+1], arr[i]);
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n && j < n){
            if (left[i] < right[j]){
                ans = Math.max(ans, j - i);
                j++;
            }
            else i++;
        }
        return ans;
    }

    Node remove(Node head){
        Set<Integer> set = new HashSet<>();
        Node dummy = new Node(-1);
        Node current = dummy;
        while (head != null){
            if (set.contains(head.value)){
                current.next = head;
                current = current.next;
            }
            head = head.next;
            set.add(head.value);
        }
        return dummy;
    }

    int search(int[] arr, int key) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] == key) return mid;
            if (arr[low] < arr[mid]){
                if (arr[mid] > key && key >= arr[low])
                    high = mid - 1;
                else low = mid + 1;
            }
            else {
                if (arr[mid] < key && key <= arr[high])
                    low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotateString d  = new RotateString();
        System.out.println(d.search(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3}, 9));

    }
}


