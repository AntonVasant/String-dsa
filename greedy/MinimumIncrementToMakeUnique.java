package greedy;

import java.util.PriorityQueue;

public class MinimumIncrementToMakeUnique {
    public int minIncrementForUnique(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums)
            pq.offer(n);
        int count = 0;
        int prev = pq.poll();
        while (!pq.isEmpty()){
            int n = pq.poll();
            if (n <= prev){
                count += prev +1- n;
                prev = prev+1;
            }
            else prev = n;
        }
        return count;
    }
}
