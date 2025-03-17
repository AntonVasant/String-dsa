package binarysearch;

import greedy.GreaterNumber;

import java.util.Arrays;
import java.util.Comparator;

public class AssignWork {
    public static int assignWork(int[] difficulty,int[] profit,int[] workers){
        int totalProfit = 0;
        int n = difficulty.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++){
             pairs[i][0] = difficulty[i];
             pairs[i][1] = profit[i];
        }
        Arrays.sort(pairs,(a,b) -> a[1] - b[1]);
        for (int[] num : pairs)
            System.out.print(Arrays.toString(num)+" ");
         for (int worker : workers)
             totalProfit += assigning(pairs,worker);
        return totalProfit;
    }
    public static int assigning(int[][] pairs,int workerCapacity){
        int ans = 0;
        for(int i = pairs.length-1; i >= 0; i--){
            if (workerCapacity <= pairs[i][0]){
                ans = pairs[i][1];
                break;
            }
        }

        return ans;
    }


    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length;
        int m = words.length;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++){
            arr[i] = helper(words[i]);
        }

        Arrays.sort(arr);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            int number = helper(queries[i]);
            ans[i] = binarySearch(arr, number);
        }

        return ans;
    }


    private int binarySearch(int[] arr, int number){
        int low = 0;
        int high = arr.length-1;
        int ans = 0;
        while (low <= high){
            int mid = (low + high)/2;
            if (number < arr[mid]){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }


    private int helper(String freq){
        int[] arr = new int[26];
        for (char c : freq.toCharArray())
            arr[c - 'a']++;
        for (int i = 0; i < 26; i++)
            if (arr[i] > 0)
                return arr[i];
        return 0;
    }





    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int count = 0;
        int len = plants.length;
        int low = 0;
        int high = len - 1;
        int alice = capacityA;
        int bob = capacityB;
        while (low <= high){
            while (plants[low] <= alice){
                alice -= plants[low++];
                if (high == low) break;
            }
            count++;
            alice = capacityA;
            while (plants[high] <= bob){
                bob -= plants[high--];
                if (high == low) break;
            }
            bob = capacityB;
            count++;

        }

        return count;
    }



    //there are k children return the maximum number of candies that can be given to each child the candy can be broken
    // in to many but cannot assign candy from two piles of candies a pile is a single number in the array
    public int maximumCandies(int[] candies, long k) {
        if (candies == null || candies.length == 0) return 0;
        int low = 1;
        int high = Arrays.stream(candies).max().getAsInt();
        int max = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canSplitCandies(candies, mid, k)){
                low = mid + 1;
                max = mid;
            }
            else high = mid - 1;
        }
        return max;
    }

    private boolean canSplitCandies(int[] candies, int numberOfCandies, long children){
        long count = 0;

        for (int candy : candies){
            count += candy/numberOfCandies;
        }
        return count >= children;
    }



    public static void main(String[] args) {
        AssignWork work = new AssignWork();
       work.maximumCandies(new int[]{5,8,6}, 3);
    }

}
