package array;

import java.util.Arrays;

public class Sort012 {
    public static void sort(int[] a){
        int low = 0;
        int high = a.length-1;
        int mid = 0;
        while (mid <= high){
            if (a[mid] == 0){
                swap(a,low,mid);
                mid++;
                low++;
            } else if (a[mid] == 1) {
                mid++;
            }else {
                swap(a,mid,high);
                high--;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] array,int low,int high){
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }
}
