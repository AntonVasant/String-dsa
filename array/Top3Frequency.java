package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Top3Frequency {
    public List<Integer> freq(int[] array){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : array){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)-> b.getValue()- a.getValue());
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<Math.min(3,list.size());i++){
            result.add(list.get(i).getKey());
        }
        return result;
    }
}
