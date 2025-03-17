package graph;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartingIndexAll {

    private static int[][] dir = {{1,0},{0,1},{1,1},{-1,-1},{-1,0},{0,-1},{1,-1},{-1,1}};
    public int[][] searchWord(char[][] grid, String word)
    {
        List<List<Integer>> list = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == word.charAt(0)){
                    if (helper(grid,i,j,word,2)){
                        list.add(new ArrayList<>(Arrays.asList(i,j)));
                    }
                }
            }
        }
        int len = list.size();
        int[][] ans = new int[len][2];
        int i = 0;
        for (List<Integer> l : list){
            ans[i][0] = l.get(0);
            ans[i][1] = l.get(1);
            i++;
        }
        return ans;
    }


    private static boolean helper(char[][] board, int i, int j, String s, int index) {
        if (index == s.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != s.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        System.out.println(temp);
        for (int[] arr : dir) {
            int x = arr[0] + i;
            int y = arr[1] + j;
            if (helper(board, x, y, s, index + 1)) {
               return true;
            }
        }
        board[i][j] = temp;
        return false;
    }


    public static void main(String[] args) {
        System.out.println(helper(new char[][]{{'a','b','c'},{'d','e','f'},{'h','i','j'}},0,0,"abc",0));
    }
}
