package greedy;

import java.util.PriorityQueue;

public class MaximumApplesToEat {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int i = 0;
        int day = 0;
        while (i < apples.length || !pq.isEmpty()){
            while (!pq.isEmpty() && pq.peek()[0] <= i)
                pq.poll();
            if (i < apples.length && apples[i] > 0)
                pq.offer(new int[]{i + days[i],apples[i]});
            if (!pq.isEmpty()){
                int[] cur = pq.peek();
                cur[1]--;
                if (cur[1] == 0)
                    pq.poll();
                day++;
            }
            i++;
        }
        return day;
    }
}
