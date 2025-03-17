package stack;

import java.util.Arrays;
import java.util.Stack;

public class LongestValidParanthesis {
    public static int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        st.push(-1);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else if(s.charAt(i)==')'){
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    ans = Math.max(ans,i-st.peek());
                }
            }
        }
        return ans;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] memo = new Boolean[n][m];
        return helper(s,p,0,0,memo);
    }

    private boolean helper(String s, String p, int i, int j, Boolean[][] memo){
        if (j == p.length())
            return i == s.length();
        if (i == s.length()){
            for (int index = j; index < p.length(); index++){
                if (p.charAt(index) != '*')
                    return false;
            }
            return true;
        }

        if (memo[i][j] != null)
            return memo[i][j];

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return helper(s, p, i+1, j+1, memo);

        boolean result = false;
        if (p.charAt(j) == '*'){
            result = helper(s, p, i, j+1, memo) || helper(s, p, i + 1, j, memo);
        }

        memo[i][j] = result;
        return result;
    }
    public static boolean canJump(int[] nums) {
        int jumps = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++){
            if (i > jumps) return false;
            jumps = Math.max(jumps, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        canJump(new int[]{2,3,1,1,4});
    }
}
