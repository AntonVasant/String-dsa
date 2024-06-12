package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0],b[0]));
        List<List<Integer>> list  = new ArrayList<>();
        for(int i = 0; i < intervals.length;i++){
            if(list.isEmpty() || list.get(list.size()-1).get(1) < intervals[i][0])
                list.add(Arrays.asList(intervals[i][0],intervals[i][1]));
            else{
                list.get(list.size()-1).set(1,Math.max(list.get(list.size()-1).get(1),intervals[i][1]));
            }
        }
        int[][] arr = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            List<Integer> inner = list.get(i);
            for(int j = 0; j < 2; j ++){
                arr[i][j] = inner.get(j);
            }
        }
        return arr;
    }
}
