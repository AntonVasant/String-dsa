package graph;

import java.util.LinkedList;
import java.util.Queue;

public class GridWords {
    public int[][] searchWord(char[][] grid, String word)
    {
        int[][] dir = {{1,1},{1,0},{0,1},{-1,-1},{-1,0},{0,-1},{-1,1},{1,-1}};
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == word.charAt(0)){
                    for (int[] d : dir){
                        int[][] n = search(grid,new Cells(i,j,null),word,d,1);
                        if (n != null && n.length == word.length())
                            return n;
                    }
                }
            }
        }
        return null;
    }

    private int[][] trace(Cells cells,int n){
        int i = 0;
        int[][] ans = new int[n][2];
        while(cells.prev != null){

           ans[i][0] = cells.row;
           ans[i][1] = cells.col;
           cells = cells.prev;
        }
        int low = 0;
        int high = ans.length-1;
        while (low < high){
            int[] temp = ans[low];
            ans[low] = ans[high];
            ans[high] = temp;
            low++;
            high--;
        }
        return ans;
    }

    private int[][] search(char[][] grid,Cells current,String str,int[] dir,int index){
        Queue<Cells> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        queue.offer(current);
        while (!queue.isEmpty()){
            Cells cur = queue.poll();
            if (index == str.length()){
                return trace(cur,str.length());
            }
            int x  = cur.row + dir[0];
            int y = cur.col + dir[1];
            if (x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == str.charAt(index)){
                queue.offer(new Cells(x,y,cur));
                index+=1;
            }
        }
        return null;
    }
}
