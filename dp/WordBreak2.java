package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String,List<String>> memo = new HashMap<>();
        List<String> res = helper(memo,s,wordDict);
        return res;
    }

    private List<String> helper(Map<String,List<String>> memo,String s,List<String> words){
        if (memo.containsKey(s))
            return memo.get(s);
        List<String> list = new ArrayList<>();
        if (s.isEmpty()){
            list.add("");
            return list;
        }

        for (String str : words){
            if (s.startsWith(str)){
                String rem = s.substring(str.length());
                List<String> res = helper(memo,rem,words);
                for (String st : res){
                    String space = st.isEmpty() ? "" : " ";
                    list.add(str+space+st);
                }
            }
        }
        memo.put(s,list);
        return list;
    }
}
