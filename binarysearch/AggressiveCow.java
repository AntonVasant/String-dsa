package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
