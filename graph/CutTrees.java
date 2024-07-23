package graph;
import java.util.*;
import java.util.List;

public class CutTrees {
    public int cutOffTree(List<List<Integer>> forest) {
        int row = forest.size();
        int col = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (forest.get(i).get(j) > 1){
                    pq.offer(new int[]{forest.get(i).get(j),i,j});
                }
            }
        }

        int steps = 0;
        int startx = 0;
        int starty = 0;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int abs = bfs(forest,startx,starty,cur[0]);
            if (abs == -1) return -1;
            steps += abs;
            startx = cur[1];
            starty = cur[2];
        }
        return steps;
    }

    private int bfs(List<List<Integer>> forest,int i,int j,int target){
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int row = forest.size();
        int col = forest.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        boolean[][] visit = new boolean[row][col];
        visit[i][j] = true;
        int steps = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int k = 0; k < size; k++){
                int[] cur = queue.poll();
                if (forest.get(cur[0]).get(cur[1]) == target) return steps;
                for (int[] d :dir){
                    int newx = cur[0] + d[0];
                    int newy = cur[1] + d[1];
                    if (newx >= 0 && newy >= 0 && newx < row && newy < col &&
                            forest.get(newx).get(newy) > 0 && !visit[newx][newy]){
                        visit[newx][newy] = true;
                        queue.offer(new int[]{newx,newy});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
