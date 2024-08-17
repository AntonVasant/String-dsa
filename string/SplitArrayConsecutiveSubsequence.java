package string;

import java.util.PriorityQueue;

public class SplitArrayConsecutiveSubsequence {
    public boolean isPossible(int[] nums) {
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums)
            pq.offer(n);
        int prev = 0;
        int times = 0;
        while (!pq.isEmpty()){
            int n = pq.poll();
            if (prev == 0 || Math.abs(n - prev) == 1){
                index++;
                if (index == 3){
                    times++;
                    if (times == 2) return true;
                    prev = 0;
                }
                else prev = n;
            }
        }
        return false;
    }
}
