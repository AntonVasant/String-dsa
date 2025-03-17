package matrix;

import java.util.*;

public class SetMatrixZero {


    public static void setMatrixZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0)
                col = true;
        }

        for (int i = 0; i < m; i++){
            if (matrix[0][i] == 0)
                row = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (col)
            for (int i = 0; i < n; i++)
                matrix[i][0] = 0;
        if (row)
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        Set<String> set = new HashSet<>(wordList);
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) return count+1;
                int currentWordLength = currentWord.length();
                char[] array = currentWord.toCharArray();
                for (int j = 0; j < currentWordLength; j++) {
                    char original = array[j];
                    for (char c = 'a'; c <= 'z'; c++){
                        array[j] = c;
                        String newWord = new String(array);
                        if (set.contains(newWord)){
                            System.out.println(newWord);
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    array[j] = original;
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
    }
}
