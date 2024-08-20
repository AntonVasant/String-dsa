package greedy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class KGroupOfConsecutiveCards {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length% groupSize != 0) return false;
        Map<Integer,Integer> map= new HashMap<>();
        for (int n : hand)
            map.put(n,map.getOrDefault(n,0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(map.keySet());
        while (!pq.isEmpty()){
            int cur = pq.poll();
            for (int i = 0; i < groupSize; i++){
                int now = cur+i;
                if (!map.containsKey(now) || map.get(now) == 0) return false;
                map.put(now,map.getOrDefault(now,0)-1);
                if (map.get(now) == 0)
                    map.remove(now);
            }
        }
        return true;
    }
}
