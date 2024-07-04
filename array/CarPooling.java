package array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a, b) -> a[1] - b[1]);
        int current = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int i = 0; i < trips.length; i++){
            int start = trips[i][1];
            current += trips[i][0];
            while (!pq.isEmpty() && pq.peek()[2] <= start){
                current -= pq.poll()[0];
            }
            if(current > capacity) return false;
            pq.offer(trips[i]);
        }
        return true;
    }
}
