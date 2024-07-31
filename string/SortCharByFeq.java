package string;

import java.util.*;

public class SortCharByFeq {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        StringBuilder sb = new StringBuilder();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
               return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<Character,Integer> entry : list){
            int n = entry.getValue();
            char c = entry.getKey();
            for (int i = 0; i < n; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
