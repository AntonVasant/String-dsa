package array;

import java.util.Arrays;
import java.util.PriorityQueue;

class Project{
    int capital;
    int profit;

    public Project(int capital,int profit){
        this.capital = capital;
        this.profit = profit;
    }
}
public class IPO {
    public static int maximum(int w,int[] capital,int[] profit,int k){
        int n = capital.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++){
            projects[i] = new Project(capital[i],profit[i]);
        }
        Arrays.sort(projects,(a,b) -> a.capital - b.capital);
        PriorityQueue<Project> pq = new PriorityQueue<>((a,b) -> b.profit - a.profit);
        int i = 0;
        while (k > 0){
            while (i < n && projects[i].capital <= w){
                pq.offer(projects[i]);
                i++;
            }
            if (pq.isEmpty()) break;
            w += pq.poll().profit;
            k--;
         }
        return w;
    }
}
