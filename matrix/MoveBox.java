package matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MoveBox {
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int minPushBox(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] playerPos = new int[2];
        int[] boxPos = new int[2];
        int[] target = new int[2];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 'T') target = new int[]{i,j};
                if (grid[i][j] == 'B') boxPos = new int[]{i,j};
                if (grid[i][j] == 'S') playerPos = new int[]{i,j};
            }
        }

        int[] pos = {playerPos[0],playerPos[1],boxPos[0],boxPos[1],0};
        Queue<int[]> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        String start = playerPos[0]+","+playerPos[1]+","+boxPos[0]+","+boxPos[1];
        queue.offer(pos);
        set.add(start);
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            if (cur[2] == target[0] && cur[3] == target[1]) return cur[4];
            for (int[] dir : directions){
                int newBoxX = cur[2] + dir[0];
                int newBoxY = cur[3] + dir[1];
                int newPx = cur[0] - dir[0];
                int newpY = cur[1] - dir[1];
                String state = newPx+","+newpY+","+newBoxX+","+newBoxY;
                if (canMove(newBoxX,newBoxY,row,col,grid) && canMove(newPx,newpY,row,col,grid)){
                    if (isValid(cur[0],cur[1],newPx,newpY,newBoxX,newBoxY,grid) && !set.contains(state)){
                        set.add(state);
                        queue.offer(new int[]{newPx,newpY,newBoxX,newBoxY,cur[4]+1});
                    }
                }
            }
        }
        return -1;
    }

    private boolean canMove(int x,int y,int row,int col,char[][] grid){
        return x >= 0 && y >= 0 && x  < row && y < col && grid[x][y] != '#';
    }

    private boolean isValid(int playerX,int playerY,int targetX,int targetY,int boxX,int boxY,char[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{playerX,playerY});
        boolean[][] visit = new boolean[row][col];
        visit[playerX][playerY] = true;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            if (cur[0] == targetX && cur[1] == targetY) return true;
            for (int[] dir : directions){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (canMove(x,y,row,col,grid) && !visit[x][y] && x != boxX && y != boxY){
                    queue.offer(new int[]{x,y});
                    visit[x][y] = true;
                }
            }
        }
        return false;
    }
}
