package twopointer;

import rescursion.LongestCommomSubArray;

public class Main {
    public static void main(String a[]){
        int[] array1 = {4,3,6,4,3,2,1};
        int[] array2 = {6,3,7,4,3,1};
        int n = LongestCommomSubArray.findLength(array1,array2);
        System.out.println(n);
    }
}
