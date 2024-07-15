package stack;

import java.util.Stack;

public class LongestValidParanthesis {
    public int longestValidParentheses(String s) {
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
}
