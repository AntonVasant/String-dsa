package string;

import java.util.*;

public class GroupAnagram {
    public List<List<String>> anagram(String[] str){
        Map<String,List<String>> map = new HashMap<>();
        for(String word : str){
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String sorted  = new String(ch);
            if(map.containsKey(sorted)){
                map.get(sorted).add(word);
            }else{
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(sorted,list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
