package string;

import java.util.PriorityQueue;

public class Medals {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for (int i = 0; i < score.length; i++){
            pq.offer(new int[]{score[i],i});
        }
        int index = 4;
        int i = 0;
        while (!pq.isEmpty()){
            if (i == 0)
                ans[pq.poll()[1]] = "Gold Medal";
            else if (i == 1)
                ans[pq.poll()[1]] = "Silver Medal";
            else if (i == 2)
                ans[pq.poll()[1]] = "Bronze Medal";
             else {
                int pos = pq.poll()[1];
                ans[pos] = String.valueOf(index++);
            }
           i++;
        }
        return ans;
    }
}
