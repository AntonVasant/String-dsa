package rescursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans,n,0,0,"");
        return ans;
    }

    private void helper(List<String> ans,int n,int open,int close,String current){
        if(current.length() == 2*n){
            ans.add(current);
            return;
        }
        if(open < n){
            helper(ans,n,open+1,close,current+"(");
        }
        if(close < open){
            helper(ans,n,open,close+1,current+")");
        }
    }
}
