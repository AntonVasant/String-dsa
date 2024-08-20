package array;
import java.util.Deque;
import java.util.LinkedList;

public class SmallestArrayWithSumAtleastK {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        Deque<Integer> deque = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++){
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k)
                min = Math.min(min,i-deque.pollFirst());
            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
        }
        return min;
    }
}
