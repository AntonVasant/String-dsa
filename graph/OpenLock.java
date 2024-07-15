package graph;

import java.util.*;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        if (set.contains(target)) return -1;
        if (set.contains("0000")) return -1;
        if (target.equals("0000")) return 0;
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        int count = 0;
        while (!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String current = queue.poll();
                List<String> combinations = generate(current);
                for(String str : combinations){
                    if (str.equals(target)) return count;
                    if (!visited.contains(str) && !set.contains(str)){
                        visited.add(str);
                        queue.offer(str);
                    }
                }
            }
        }
        return -1;
    }


    private List<String> generate(String str){
        List<String> res = new ArrayList<>();
        char[] array = str.toCharArray();
        for(int i = 0; i < str.length() ;i++){
            char original = array[i];
            array[i] = original == '9' ? '0' : (char) (original+ 1);
            res.add(new String(array));
            array[i] = original == '0' ? '9' : (char) (original -1);
            res.add(new String(array));
            array[i] = original;
        }
        return res;
    }
}
