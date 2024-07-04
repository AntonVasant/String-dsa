package twopointer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Set<String> ans = new HashSet<>();
        for(int i = 0; i <= s.length()-10;i++){
            String str = s.substring(i,i+10);
            if(seen.contains(str)){
                ans.add(str);
            }seen.add(str);
        }
        for(String str : ans){
            list.add(str);
        }
        return list;
    }
}
