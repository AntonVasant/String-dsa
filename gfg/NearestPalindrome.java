package gfg;

import java.util.Arrays;
import java.util.HashSet;

public class NearestPalindrome {
    public static String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int length = n.length();
        HashSet<Long> set = new HashSet<>();
        set.add((long)(Math.pow(10,length) + 1));
        set.add((long) (Math.pow(10, length-1)-1));
        long prefix = Long.parseLong(n.substring(0, (length+1)/2));
        System.out.println(prefix);
        for (int i = -1; i <= 1; i++){
            StringBuilder firstHalf = new StringBuilder();
            firstHalf.append(prefix+ i);
            System.out.println(prefix + i);
            String ans = firstHalf + new StringBuilder(firstHalf.substring(0,length/2)).reverse().toString();
            set.add(Long.parseLong(ans));
        }
        long current = -1;
        System.out.println(set);
        for (long number : set){
            if (number != num){
                if (current == -1 || Math.abs(num - number) < Math.abs(num - current) ||
                        Math.abs(num - number) == Math.abs(num - current) && number < current){
                    current = number;
                }
            }
        }
        return String.valueOf(current);
    }

    public static int minDifference(int arr[], int n)
    {
        int total = Arrays.stream(arr).sum();
        Integer[][] dp = new Integer[n][total+1];
        return helper(dp,n-1,0,total,arr);
    }

    private static int helper(Integer[][] dp, int index, int current, int total,int[] array){
        if (index < 0){
            int sum1 = total - current;
            return Math.abs(sum1 - current);
        }

        if (dp[index][current] != null) return dp[index][current];

        int take = helper(dp, index-1, current + array[index], total,array);
        int non = helper(dp, index-1, current, total, array);

        dp[index][current] = Math.min(take,non);
        return dp[index][current];
    }


    public static void quickSort(int[] arr, int left, int right){
        if (left < right){
            int next = nextPivot(arr, left, right);
            System.out.println(next);
            quickSort(arr, left, next-1);
            quickSort(arr, next + 1, right);
        }
    }


    private static int nextPivot(int[] arr, int left, int right){
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,6,8,3,1,7,9,2};
        System.out.println(nearestPalindromic("123"));
    }
}
