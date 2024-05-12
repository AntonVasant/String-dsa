package array;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public Set<Integer> intersection(int[] array1,int[] array2){
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
         for(int i=0;i< array1.length;i++){
             set.add(array1[i]);
         }
         for(int num : array2){
             if(set.contains(num))
                 set1.add(num);
         }
         return set1;
    }
}
