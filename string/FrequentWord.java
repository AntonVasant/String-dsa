package string;

import java.util.*;

public class FrequentWord {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String ,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String s : words)
            map.put(s,map.getOrDefault(s,0)+1);
        List<Map.Entry<String,Integer>> list1 = new ArrayList<>(map.entrySet());
        list1.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue())
                    return o1.getKey().compareTo(o2.getKey());
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < k; i++){
            list.add(list1.get(i).getKey());
        }
        return list;
    }
}
