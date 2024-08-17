package greedy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length; // No cooldown means just executing all tasks sequentially

        // Step 1: Count frequency of each task
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }

        // Step 2: Max-Heap to store frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : frequencies) {
            if (freq > 0) {
                maxHeap.offer(freq);
            }
        }

        int time = 0;
        Queue<int[]> cooldownQueue = new LinkedList<>();

        // Step 3: Process tasks using the greedy approach
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int currentFreq = maxHeap.poll() - 1; // Process the most frequent task
                if (currentFreq > 0) {
                    cooldownQueue.offer(new int[] { currentFreq, time + n }); // Push into cooldown
                }
            }

            // Check if a task has finished its cooldown
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                maxHeap.offer(cooldownQueue.poll()[0]); // Reinsert back into heap
            }
        }

        return time;
    }
}
