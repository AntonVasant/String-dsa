package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortBasedOnFreq {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num,map.getOrDefault(num,0)+1);
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue())
                    return o2.getKey() - o1.getKey();
                return o1.getValue() - o2.getValue();
            }
        });
        pq.addAll(map.entrySet());
        for (int i = 0; i < nums.length; i++){
            nums[i] = pq.peek().getKey();
            pq.peek().setValue(pq.peek().getValue()-1);
            if (pq.peek().getValue() == 0) pq.poll();
        }
        return nums;
    }
}
