package greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistinctBarCode {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int n : barcodes)
            map.put(n,map.getOrDefault(n,0)+1);
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        Map.Entry<Integer,Integer> prev = null;
        int index = 0;
        pq.addAll(map.entrySet());
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> curr = pq.poll();
            barcodes[index++] = curr.getKey();
            curr.setValue(curr.getValue() - 1);
            if (prev != null && prev.getValue() > 0)
                pq.offer(prev);
            prev = curr;
        }
        return barcodes;
    }
}
