package greedy;

import java.util.*;

public class TaskScheduler2 {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> lastExecutionDay = new HashMap<>();
        long currentDay = 0;

        for (int task : tasks) {
            if (lastExecutionDay.containsKey(task)) {
                long nextAvailableDay = lastExecutionDay.get(task) + space + 1;
                if (currentDay < nextAvailableDay) {
                    currentDay = nextAvailableDay;
                }
            }
            lastExecutionDay.put(task, currentDay);
            currentDay++;
        }

        return currentDay;
    }
}
