package dp;

import java.util.*;

public class EatOranges {
    public int minDays(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(n);
        set.add(n);
        int days = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++){
                int current = queue.poll();
                if (!set.contains(current)){
                    set.add(current-1);
                    queue.offer(current-1);
                }
                if (current == 0) return days;
                if (current % 2 == 0){
                    queue.offer(current/2);
                    set.add(current/2);
                }
                if (current % 3 == 0){
                    queue.offer(2*current/3);
                    set.add(2*current/3);
                }

            }
            days++;
        }
        return -1;
    }
}
