package array;

import java.util.Set;

public class ZohoL2 {
    public static void moveNumbers(int[] array, Set<Integer> set){
        int n = 0;
        for (int num : array){
            if (!set.contains(num)){
                array[n++] = num;
            }
        }
        for (int num : array){
            if (set.contains(num)){
                array[n++] = num;
            }
        }
        for (int num : array)
            System.out.print(num+" ");
    }
}
