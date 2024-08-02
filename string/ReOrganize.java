package string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReOrganize {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        Map.Entry<Character,Integer> prev = null;
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()){
            Map.Entry<Character,Integer> current = pq.poll();
            ans.append(current.getKey());
            current.setValue(current.getValue()-1);
            if (prev != null && prev.getValue() > 0)
                pq.offer(prev);
            prev = current;
        }
        if (ans.length() == s.length())
            return ans.toString();
        return "";
    }
}
