package graph;

import java.util.*;

public class RemoveInvalidParanthesis {
    public static void remove(String s){
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        set.add(s);
        while (!queue.isEmpty()){
            String current = queue.poll();
            boolean found = false;
            if (isValid(current)){
                found = true;
               if(current.length() == s.length()-1) result.add(current);
            }
            if (found) continue;
            for (int i = 0;i < current.length(); i++){
                String st = current.substring(0,i) + current.substring(i+1);
                if (!set.contains(st)){
                    set.add(st);
                    queue.offer(st);
                }
            }
        }
        System.out.println(result);
    }

    private static boolean isValid(String s){
        int count = 0;
        for (char c : s.toCharArray()){
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    public static void main(String[] a){
        remove("()())()");
    }
}
