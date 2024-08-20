package greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeToHalf {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int n : arr)
            map.put(n,map.getOrDefault(n,0)+1);
        int count = 0;
        int n = arr.length;
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        while (n > arr.length/2 && !pq.isEmpty()){
            n -= pq.poll().getValue();
            count++;
        }
        return count;
    }
}
