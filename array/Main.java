package array;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String a[]) {
         int[] array = {16,13,6,5,1,3,5};
        Set<Integer> set = new HashSet<>();
        set.add(6);
        set.add(5);
        ZohoL2.moveNumbers(array,set);
    }
}