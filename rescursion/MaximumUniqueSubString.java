package rescursion;

import java.util.HashSet;
import java.util.Set;

public class MaximumUniqueSubString {

    public int maxUniqueSplit(String s) {
        return helper(s,0,new HashSet<>());
    }

    private int helper(String s, int index, Set<String> set){
        if (index == s.length()) return 0;
        int max = 0;
        for (int i = index+1; i <= s.length(); i++){
            String sub = s.substring(index,i);
            if (!set.contains(sub)){
                set.add(sub);
                max = Math.max(max,1 + helper(s,i,set));
                set.remove(sub);
            }
        }
        return max;
    }
}
