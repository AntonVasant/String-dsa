package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PairGameUntilTwoNonZeroNumber {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y - x);
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);
        int ans = 0;
        while (pq.size() > 1){
            int first = pq.poll();
            if (pq.peek() > 0){
                int sec = pq.poll();
                first--;
                sec--;
                if (first > 0)pq.offer(first);
                if (sec > 0)pq.offer(sec);
                ans++;
            }
            else break;
        }
        return ans;
    }
}
