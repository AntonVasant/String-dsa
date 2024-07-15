package rescursion.bfsdfs;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        int count = 0;
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String current = queue.poll();
                if (current.equals(endWord)) return count+1;
                char[] array = current.toCharArray();
                for(int j = 0; j < array.length; j++){
                    char originalChar = array[j];
                    for(char c = 'a'; c <='z'; c++){
                        if (c == originalChar) continue;
                        array[j] = c;
                        String str = new String(array);
                        if(set.contains(str)){
                            queue.offer(str);
                            set.remove(str);
                        }
                        array[j] = originalChar;
                    }
                }

            }
            count++;

        }
        return 0;
    }
}
