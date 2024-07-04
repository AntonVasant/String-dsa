package array;

import java.util.*;

public class SumEqualsKPosition {
    public static List<Integer> position(int[] array,int n,int target){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += array[i];
            int remove  = sum - target;
            if (map.containsKey(remove)){
                return new ArrayList<>(Arrays.asList(map.get(remove),i+1));
            }
            map.put(sum,i+2);
        }
        return new ArrayList<>(Arrays.asList(-1,-1));
    }
}
