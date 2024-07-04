package array;

import java.util.Arrays;
import java.util.TreeMap;

//trash
public class MaximumProfitJob {
    class Intervals{
        int start;
        int end;
        int profit;
        Intervals(int start,int end,int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Intervals[] interval = new Intervals[n];
        for(int i = 0; i < n; i++){
            interval[i] = new Intervals(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(interval,(a, b) -> a.end - b.end);
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(0,0);
        for(Intervals inter : interval){
            int current = map.floorEntry(inter.start).getValue() + inter.profit;
            if(current > map.lastEntry().getValue()){
                map.put(inter.end,current);
            }
        }
        return map.lastEntry().getValue();
    }
}
