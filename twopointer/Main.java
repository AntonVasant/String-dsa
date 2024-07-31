package twopointer;

import rescursion.LongestCommomSubArray;

public class Main {
    public static void main(String a[]){
        long[] arr = {5, 6, 3, 5, 7, 8, 9, 1, 2};
        LongestIncreasingSubArray n = new LongestIncreasingSubArray();
        long s = n.lenOfLongIncSubArr(arr, a.length);
        System.out.println(s);
    }
}
