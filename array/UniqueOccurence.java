package array;

import java.net.Inet4Address;
import java.util.*;

public class UniqueOccurence {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for (int i = 1; i < list.size(); i++){
            if (list.get(i).getValue().equals(list.get(i-1).getValue())) return false;
        }
        return true;
    }
}
