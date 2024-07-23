package stack;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");
        for (String s : arr){
            if (s.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.isEmpty()) {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
       for (String st : stack)
           sb.append("/").append(st);
        return sb.length() > 0 ? sb.toString() : "/";
    }
}
