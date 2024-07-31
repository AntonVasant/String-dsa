package string;

import java.util.*;

public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        return helper(set);
    }


    private String helper(Set<String> set){
        String ans = "";
        Queue<String> queue = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        for (String s  : set){
            if (s.length() == 1){
                queue.offer(s);
                visit.add(s);
            }
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String cur = queue.poll();
                if (cur.length() > ans.length())
                    ans = cur;
                for (char c = 'a'; c <= 'z'; c++){
                    String str = new String(cur+c);
                    if (set.contains(str) && !visit.contains(str)){
                            queue.offer(str);
                            visit.add(str);
                        }
                    }
                }
            }
        return ans;
    }
}
