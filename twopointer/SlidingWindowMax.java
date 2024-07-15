package twopointer;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {
        public static int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }

            // Initialize deque and result array
            Deque<Integer> deque = new ArrayDeque<>();
            int[] result = new int[nums.length - k + 1];

            // Iterate through the array
            for (int i = 0; i < nums.length; i++) {
                // Remove indices out of the current window
                if (!deque.isEmpty() && deque.getFirst() < i - k + 1) {
                    deque.pollFirst();
                }

                // Remove elements from the back if they are smaller than the current element
                while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                    deque.pollLast();
                }

                // Add current element index to the deque
                deque.offerLast(i);

                // Store the maximum value for the current window
                if (i >= k - 1) {
                    result[i - k + 1] = nums[deque.getFirst()];
                }
            }

            return result;
        }
}
