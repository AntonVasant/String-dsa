package graph;

import java.util.*;
import java.util.List;

public class Gene {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Queue<String> queue = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        queue.offer(startGene);
        int count = 0;
        while (!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String current = queue.poll();
                List<String> combs = generate(current);
                for (String s : combs){
                    if (!set.contains(s)) continue;
                    if (s.equals(endGene)) return count;
                    if (!visit.contains(s)){
                        queue.offer(s);
                        visit.add(s);
                    }
                }
            }
        }
        return -1;

    }

    private List<String> generate(String s){
        List<String> list = new ArrayList<>();
        char[] array = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            char original = array[i];
            array[i] = 'A';
            String one = new String(array);
            list.add(one);
            array[i] = 'C';
            String two = new String(array);
            list.add(two);
            array[i] = 'G';
            String three = new String(array);
            list.add(three);
            array[i] = 'T';
            String four = new String(array);
            list.add(four);
            array[i] = original;
        }
        return list;
    }
}
