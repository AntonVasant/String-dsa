package graph;


import java.util.Map;
import java.util.PriorityQueue;

class Cell{
    int row;
    int col;
    int height;
    public Cell(int row,int col,int height){
        this.row  =row;
        this.col = col;
        this.height = height;
    }
}
public class RainWaterTrapped2{
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b)-> a.height - b.height);
        int m = heightMap.length;
        int n = heightMap[0].length;
        int water = 0;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < n; i++){
            pq.offer(new Cell(0,i,heightMap[0][i]));
            pq.offer(new Cell(m-1,i,heightMap[m-1][i]));
            visit[m-1][i] = true;
            visit[0][i] = true;
        }
        for (int i = 0; i < m; i++){
            pq.offer(new Cell(i,0,heightMap[i][0]));
            pq.offer(new Cell(i,n-1,heightMap[i][n-1]));
            visit[i][0] = true;
            visit[i][n-1] = true;
        }
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while (!pq.isEmpty()){
            Cell cell = pq.poll();
            for (int[] d : dir){
                int x = cell.row + d[0];
                int y = cell.col + d[1];

                if (x >= 0 && y >= 0 && x < m && y < n && !visit[x][y]){
                    visit[x][y] = true;
                    water += Math.max(0, cell.height - heightMap[x][y]);
                    pq.offer(new Cell(x,y,Math.max(heightMap[x][y],cell.height)));
                }
            }
        }
        return water;
    }
}
