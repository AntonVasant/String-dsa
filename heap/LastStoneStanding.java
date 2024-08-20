package heap;

import java.util.PriorityQueue;

public class LastStoneStanding {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : stones)
            pq.offer(n);
        while (!pq.isEmpty()){
            if (pq.size() > 1){
                int first = pq.poll();
                int sec = pq.poll();
                pq.offer(Math.abs(first-sec));
            }
            else return pq.peek();
        }
        return -1;
    }
}
