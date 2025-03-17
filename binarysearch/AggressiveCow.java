package binarysearch;

import java.util.*;


public class AggressiveCow {
    public static int cows(int[] array,int cow){
        Arrays.sort(array);
        int low = 1;
        int high = array[array.length-1];
        int mid;
        int ans = 0;
        while (low <= high){
            mid = (low + high)/2;
            if(helper(array,cow,mid)){
                ans = mid;
                low = mid + 1;
            }else high = mid - 1;
        }
        return ans;
    }

    private static boolean helper(int[] array,int cows,int mid){
        int currentCow = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] - currentCow >= mid){
                cows--;
                currentCow = array[i];
            }
        }
        return cows <= 1;
    }




    public static boolean areRotations(String s1, String s2) {
        String text = s1+s1;
        int[] lps= lps(s2);
        int i = 1;
        int j = 0;
        int n =  text.length();
        while (i < n){
            if (text.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
            if (j == s2.length())
                return true;
            else if (i < n && text.charAt(i) != s2.charAt(j)){
                if (j != 0)
                    j = lps[j-1];
                else i++;
            }
        }
        return false;
    }

    private static int[] lps(String pattern){
        int n = pattern.length();
        int[] arr = new int[n];
        int i = 0;
        int j = 0;
        while (i < n){
            if (pattern.charAt(i) == pattern.charAt(j)){
                j++;
                arr[i] = j;
                i++;
            }
            else {
                if (j != 0){
                    j = arr[j-1];
                }
                else {
                    arr[i] = 0;
                    i++;
                }
            }
        }
        return arr;
    }



    public static int maxOccured(int n, int l[], int r[], int maxx) {
        int[] freq = new int[maxx+2];


        for (int i = 0; i < l.length; i++){
            freq[l[i]]++;
            freq[r[i]+1]--;
        }


        int maxIndex = 0;
        int sum = 0;
        int maxSim = 0;
        for (int i = 0; i <= maxx; i++){
            sum += freq[i];
            if (sum > maxSim){
                maxSim = sum;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static String binary(int n, int d) {
        StringBuilder builder = new StringBuilder();
        while (n > 0){
            builder.append(n % 2);
            n/= 2;
        }
        return builder.reverse().toString();
    }

    static int minNumber(int arr[], int low, int high){
        int min = Integer.MAX_VALUE;
        while (low < high){
            int mid = (low + high)/2;
            if (arr[low] <= arr[mid]){
                min = Math.min(min, arr[low]);
                low = mid + 1;
            }
            else {
                min = Math.min(min, arr[mid]);
                high = mid -1;
            }
        }
        return min;
    }
    public static int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        int i = 0;
        int j = 0;
        int n = arr1.size();
        int m = arr2.size();
        int sum1 = 0;
        int sum2 = 0;
        int res = 0;
        Collections.sort(arr1);
        Collections.sort(arr2);
        while (i < n && j < m){
            if (arr1.get(i) == arr1.get(j)){
                res += Math.max(sum2, sum1) + arr1.get(i);
                i++;
                j++;
                sum2 = 0;
                sum1 = 0;
            }
            else {
                if (arr1.get(i) > arr2.get(j))
                    sum1 += arr1.get(i++);
                else {
                    sum2 += arr2.get(j++);
                }
            }
        }
        while (i < n)
            sum1 += arr1.get(i++);
        while (j < m)
            sum2 += arr2.get(j++);
        res += Math.max(sum2, sum1);
        return res;
    }
    static int[] constructLowerArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        List<Integer> list=  new ArrayList<>();
        for (int i = n-1; i >= 0; i--){
            int number = binarySearchHelper(list, arr[i]);
            ans[i] = number;
        }
        return ans;
    }
    private static int binarySearchHelper(List<Integer> list, int num){
        int size = list.size();
        int low = 0;
        int high = size-1;
        while (low <= high){
            int mid = (low + high)/2;
            if (list.get(mid) < num){
                low = mid +1;
            }
            else high = mid - 1;
        }
        list.add(low, num);
        return low;
    }
    /*
    Input: arr[] = [12, 1, 2, 3, 0, 11, 4]
    Output: [6, 1, 1, 1, 0, 1, 0]
     */
    public static void Rearrange(int a[], int n){
        int index = 0;
        for (int i = 0; i < n; i++){
            if (a[i] < 0){
                int temp = a[i];
                for (int j = i; j > index; j--){
                    a[j] = a[j-1];
                }
                a[index++] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
    }
    ArrayList<Integer> search(String pattern, String text){
        int[] lps = lps(pattern);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n = text.length();
        int m = pattern.length();
        while (i < n){
            if (text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            if (j == m){
                list.add(i - j);
                j = lps[j-1];
            }

            else if (i < n && text.charAt(i) != pattern.charAt(j)){
                if (j != 0)
                    j = lps[j-1];
                else
                    i++;
            }
        }
        return list;
    }
    ArrayList<Integer> removeDuplicate(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++){
            if (arr[i] != arr[i-1])
                list.add(arr[i]);
        }
        return list;
    }

    public int alternatingMaxLength(int[] arr) {
        int first = findLongestAlternating(arr,0, true, -1);
        int sec = findLongestAlternating(arr,0, false, Integer.MAX_VALUE);
        return Math.max(first, sec);
    }
    private int findLongestAlternating(int[] arr, int index, boolean isIncreasing, int prev){
        if (index == arr.length)
            return 0;
        int take = 0;
        if (isIncreasing){
            if (arr[index] > prev)
                take = 1 + findLongestAlternating(arr,index+1, false, arr[index]);
        }
        else {
            if (arr[index] < prev)
                take = 1 + findLongestAlternating(arr, index+1, true, arr[index]);
        }
        int non = findLongestAlternating(arr, index+1, isIncreasing, prev);
        return Math.max(take, non);
    }
    public static int maxProfit(int n, int[] price) {
        int[][] dp = new int[n][2];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return stock(dp,0,1,2,price);
    }

    private static int stock(int[][] dp, int index, int buy , int k, int[] arr){
        if (k == 0 || index == arr.length) return 0;
        if (dp[index][buy] != -1) return dp[index][buy];
        int profit;
        if (buy == 1){
            profit = Math.max(-arr[index] + stock(dp, index+1, 0, k, arr),
                    stock(dp, index+1, buy, k, arr));
        }
        else profit = Math.max(arr[index] + stock(dp, index, 1, k--, arr), stock(dp, index+1, buy, k, arr));
        return dp[index][buy] = profit;
    }

    static String printMinNumberForPattern(String S){
        // code here
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 1; // Start with the smallest digit (1)

        for (int i = 0; i <= S.length(); i++) {
            stack.push(num++);
            if (i == S.length() || S.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }


    public int maxOnes(int arr[], int k) {
        int count = 0;
        int left = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0)
                count++;

            while (count > k){
                if (arr[left] == 0)
                    count--;
                left++;
            }
            max = Math.max(max, i - left+1);
        }
        return max;
    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1=nums1.length,n2=nums2.length,i=0,j=0;
        ArrayList<int []>ans=new ArrayList<>();
        while(i < n1 && j < n2){
            if(nums1[i][0] == nums2[j][0]){
                ans.add(new int[]{nums1[i][0],nums1[i][1]+nums2[j][1]});
                i++;
                j++;
            }
            else if(nums1[i][0] < nums2[j][0]){
                ans.add(nums1[i]);
                i++;
            }
            else{
                ans.add(nums2[j]);
                j++;
            }
        }
        while(i <  n1){
            ans.add(nums1[i++]);
        }
        while(j < n2){
            ans.add(nums2[j++]);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        Rearrange(new int[]{-3, 1, 0, -2},4);
    }
}
