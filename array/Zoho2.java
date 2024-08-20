package array;

import java.util.Arrays;
import java.util.Set;

public class Zoho2 {
    public static void move(int[] arr, Set<Integer> set){
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            if (!set.contains(arr[i])){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index]  = temp;
                index++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
