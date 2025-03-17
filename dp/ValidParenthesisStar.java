package dp;

import java.util.HashMap;
import java.util.Map;

public class ValidParenthesisStar {
    public boolean checkValidString(String s) {
        Map<String,Boolean> map = new HashMap<>();
        return helper(s,map,0,0);
    }

    private boolean helper(String s,Map<String,Boolean> map,int index,int current){
        if(index == s.length())
            return current == 0;
        if (current < 0) return false;
        String key = current+","+index;
        if(map.containsKey(key))
            return map.get(key);
        boolean flag = false;
        char c = s.charAt(index);
        if(c == '('){
            flag = helper(s,map,index+1,current+1);
        }
        if(c == ')'){
            flag = helper(s,map,index+1,current-1);
        }
        if(c == '*'){
            flag = helper(s,map,index+1,current-1) ||
                    helper(s,map,index+1,current) ||
                    helper(s,map,index+1,current+1);
        }
        map.put(key,flag);
        return flag;
    }

}
