package string;

import java.util.*;

public class ShortestIndexSumWords {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        Set<String> list = new HashSet<>();
        for (int i = 0; i < list1.length; i++){
            map.put(list1[i],i);
        }
        int minIndex = Integer.MAX_VALUE;
        int current = 0;
        for (int i = 0; i < list2.length; i++){
            if (map.containsKey(list2[i])){
                current =Math.abs( map.get(list2[i]) + i);
                if (current < minIndex){
                    minIndex = current;
                    list.clear();
                    list.add(list2[i]);
                }
                if (current == minIndex)
                    list.add(list2[i]);
            }
        }
        String[] ans = new String[list.size()];
        int i = 0;
        for (String s : list){
            ans[i++] = s;
        }
        return ans;
    }
}
