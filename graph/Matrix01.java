package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    visit[i][j]  = true;
                }
            }
        }
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        int steps = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i =0 ; i < size; i++){
                int[] cur = queue.poll();
                for (int[] d : dir){
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && !visit[x][y] && mat[x][y] != 0){
                        mat[x][y] = steps;
                        visit[x][y] = true;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
            steps++;
        }
        return mat;
    }
}
