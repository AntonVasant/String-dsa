package matrix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer , Integer> map = new HashMap<>();
        for (List<Integer> list : wall){
            int count = 0;
            for (int i = 0; i < list.size()-1;i++){
                count += list.get(i);
                map.put(count,map.getOrDefault(count,0)+1);
            }
        }
        int max = 0;
        for (int n : map.values())
            max = Math.max(max,n);
        return wall.size()-max;
    }
}
