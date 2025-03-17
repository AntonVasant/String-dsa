package heap;

import java.util.*;

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


    //the middle number in the window is the median if even length the sum of middle two numbers
    //imagine the window in sorted order and find the ans
    public double[] medianSlidingWindow(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            max.offer(nums[i]);
            min.offer(max.poll());
            if (max.size() < min.size()) {
                max.offer(min.poll());
            }
        }
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        ans[0] = max.size() > min.size() ? max.peek() : (min.peek() / 2.0) + max.peek() / 2.0;
        for (int i = k; i < n; i++) {
            int x = nums[i];
            int y = nums[i - k];
            m.merge(y, 1, Integer::sum);
            if (!max.isEmpty() && max.peek() >= y) {
                min.offer(x);
                max.offer(min.poll());
            } else {
                max.offer(x);
                min.offer(max.poll());
            }
            remove(max, m);
            remove(min, m);
            ans[i - k + 1] =
                    k % 2 != 0 ? max.peek() : min.peek() / 2.0 + max.peek() / 2.0;
        }
        return ans;
    }

    private static void remove(Queue<Integer> q, Map<Integer, Integer> m) {
        while (!q.isEmpty() && m.containsKey(q.peek())) {
            m.merge(q.peek(), -1, Integer::sum);
            if (m.get(q.peek()) == 0) {
                m.remove(q.peek());
            }
            q.poll();
        }
    }

    public static void main(String[] args) {
        LastStoneStanding stoneStanding = new LastStoneStanding();
        System.out.println(Arrays.toString(stoneStanding.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));

    }
}
