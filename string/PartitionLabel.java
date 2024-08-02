package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabel {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i),i);
        int end = 0;
        int start = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            end = Math.max(end,map.get(s.charAt(i)));
            if (i == end){
                list.add(i - start+1);
                start = i+1;
            }
        }
        return list;
    }
}
