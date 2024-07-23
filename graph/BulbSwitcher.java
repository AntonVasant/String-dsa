package graph;

import java.util.*;

public class BulbSwitcher {
    public int flipLights(int n, int presses) {
        if (n == 0 || presses == 0) return 1;
        n = Math.min(n,6);
        String initial = "0".repeat(n);
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(initial);
        set.add(initial);
        for (int i = 0; i < presses; i++){
            int size = queue.size();
            for (int j = 0; j < size; j++){
                String current = queue.poll();
                List<String> list = generate(current);
                for (String s : list){
                    if (!set.contains(s)){
                        set.add(s);
                        queue.offer(s);
                    }
                }
            }
        }
        return set.size();
    }

    private List<String> generate(String str){
        List<String> res = new ArrayList<>();
        res.add(flipAll(str));
        res.add(flipEven(str));
        res.add(flipOdd(str));
        res.add(flipK(str));
        return res;
    }
    private String flipAll(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++){
            chars[i] = chars[i] == '0' ? '1' : '0';
        }
        return new String(chars);
    }

    private String flipEven(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i+=2){
            chars[i] = chars[i] == '0' ? '1' : '0';
        }
        return new String(chars);
    }

    private String flipOdd(String str){
        char[] chars = str.toCharArray();
        for (int i = 1; i < chars.length; i+=2){
            chars[i] = chars[i] == '0' ? '1' : '0';
        }
        return new String(chars);
    }
    private String flipK(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (i % 3 == 0) chars[i] = chars[i] == '0' ? '1' : '0';
        }
        return new String(chars);
    }
}
