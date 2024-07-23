package graph;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
        private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            String word = null;  // Stores words at the end nodes
        }

        // Inserts a word into the Trie
        private void insert(TrieNode root, String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;  // Mark the end of the word
        }

        // Searches for words in the board using backtracking
        private void search(char[][] board, int i, int j, TrieNode node, List<String> result) {
            char c = board[i][j];
            if (c == '#' || node.children[c - 'a'] == null) return;
            node = node.children[c - 'a'];
            if (node.word != null) {  // Found a word
                result.add(node.word);
                node.word = null;  // Avoid duplicate entries
            }
            board[i][j] = '#';
            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                    search(board, ni, nj, node, result);
                }
            }
            board[i][j] = c;
        }

        public List<String> findWords(char[][] board, String[] words) {
            TrieNode root = new TrieNode();
            for (String word : words) {
                insert(root, word);
            }

            List<String> result = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    search(board, i, j, root, result);
                }
            }
            return result;
        }
    }
