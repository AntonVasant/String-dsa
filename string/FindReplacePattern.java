package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        String p = helper(pattern);
        for (String s : words){
            if (helper(s).equals(p))
                list.add(s);
        }
        return list;
    }

    private String helper(String s){
        Map<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()){
            map.putIfAbsent(c,count++);
            sb.append(map.get(c));
        }
        return sb.toString();
    }
}
