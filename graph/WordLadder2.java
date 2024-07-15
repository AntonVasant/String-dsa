package graph;

import org.w3c.dom.DOMStringList;

import java.io.OutputStream;
import java.util.*;

public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return result;
        }

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();
        bfs(beginWord, endWord, wordSet, graph, distances);

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(result, path, beginWord, endWord, graph, distances);

        return result;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet,
                     Map<String, List<String>> graph, Map<String, Integer> distances) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distances.put(beginWord, 0);

        for (String word : wordSet) {
            graph.put(word, new ArrayList<>());
        }
        graph.put(beginWord,new ArrayList<>());
        boolean foundEnd = false;
        int level = 0;

        while (!queue.isEmpty() && !foundEnd) {
            level++;
            int size = queue.size();
            Set<String> visited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                int currentDistance = distances.get(currentWord);

                List<String> neighbors = getNeighbors(currentWord, wordSet);
                for (String neighbor : neighbors) {
                    graph.get(currentWord).add(neighbor);

                    if (!distances.containsKey(neighbor)) {
                        distances.put(neighbor, currentDistance + 1);
                        if (neighbor.equals(endWord)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                        visited.add(neighbor);
                    }
                }
            }

            wordSet.removeAll(visited);
        }
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char oldChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == oldChar) continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            chars[i] = oldChar;
        }

        return neighbors;
    }

    private void dfs(List<List<String>> result, List<String> path, String currentWord,
                     String endWord, Map<String, List<String>> graph, Map<String, Integer> distances) {
        if (currentWord.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (String neighbor : graph.get(currentWord)) {
            if (distances.get(neighbor) == distances.get(currentWord) + 1) {
                path.add(neighbor);
                dfs(result, path, neighbor, endWord, graph, distances);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        WordLadder2 wl = new WordLadder2();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> result =  wl.findLadders("hit", "cog", wordList);
        for (List<String> list : result) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
