package greedy;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : tasks)
            map.put(c,map.getOrDefault(c,0)+1);
        PriorityQueue<Integer> pq  = new PriorityQueue<>((a,b) -> b - a);
        pq.addAll(map.values());
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while (!pq.isEmpty() || !queue.isEmpty()){
            int num = 0;
            time++;
            if(!pq.isEmpty()) num = pq.poll();
            num--;
            if(num > 0) queue.offer(new int[]{num,n+time});
            if (!queue.isEmpty() &&  queue.peek()[1] <= time)
                pq.offer(queue.poll()[0]);
        }
        return time;
    }
}
