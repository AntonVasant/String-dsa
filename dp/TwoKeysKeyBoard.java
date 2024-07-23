package dp;

import java.util.HashMap;
import java.util.Map;

public class TwoKeysKeyBoard {
    public int minSteps(int n) {
        Map<String,Integer> memo = new HashMap<>();
        return helper(memo,1,0,0,n);
    }

    private int helper(Map<String,Integer> memo,int current,int clipboard,int steps,int n){
        if (current > n) return Integer.MAX_VALUE;
        if (current == n) return steps;
        String key = current+","+clipboard;
        int copy = Integer.MAX_VALUE;
        int paste = Integer.MAX_VALUE;
        if (memo.containsKey(key))
            return memo.get(key);
        if(clipboard != current)copy = helper(memo, current, current, steps+1, n);
        if(clipboard > 0)paste = helper(memo, current+clipboard, clipboard, steps+1, n);
        int ans = Math.min(copy,paste);
        memo.put(key,ans);
        return ans;
    }
}
