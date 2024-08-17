package string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MapKeyBoard {
    public int minimumPushes(String word) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        int ans = 0;
        int mark = 1;
        int index = 0;
        int increment = 8;
        pq.addAll(map.entrySet());
        while (!pq.isEmpty()){
            int times = pq.poll().getValue();
            ans += times *mark;
            index++;
            if (index == increment){
                mark++;
                increment += 8;
            }
        }
        return ans;
    }
}
