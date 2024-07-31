package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWord {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> map = new HashMap<>();
        String[] arr = s1.split("\\s+");
        for (String s : arr)
            map.put(s,map.getOrDefault(s,0)+1);
        String[] arr1 = s2.split("\\s+");
        List<String > list = new ArrayList<>();
        for (String s  : arr1){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            int n = entry.getValue();
            if (n == 1)
                list.add(entry.getKey());
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
