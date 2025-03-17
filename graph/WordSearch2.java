package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordSearch2 {
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        int row = board.length;
        int col = board[0].length;
        for (String s : words){
            for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    if (board[i][j] == s.charAt(0)){
                        if (helper(s,1,board,i,j))
                            ans.add(s);
                    }
                }
            }
        }
        return ans;
    }

    private boolean helper(String s,int index,char[][] grid,int i,int j){
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        boolean[][] visit = new boolean[row][col];
        visit[i][j] = true;
        while (!queue.isEmpty()){
            if (index == s.length()) return true;
            int[] cur = queue.poll();
            for (int[] dir : directions){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && y >= 0 && x < row && y < col && !visit[x][y] && grid[x][y] == s.charAt(index)){
                    visit[x][y] = true;
                    queue.offer(new int[]{x,y});
                }
            }
            index++;
        }
        return false;
    }
}
