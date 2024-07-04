package rescursion;

public class WordSearchInGrid {
    public static boolean isFound(char[][] grid,String word){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == word.charAt(0))
                     if(helper(grid,word,0,i,j))
                         return true;
            }
        }
        return false;
    }

    private static boolean helper(char[][] grid,String word,int index,int row,int col){
        if(index == word.length()) return true;
        if(row < 0 || col < 0 || row == grid.length ||
                col == grid[0].length || grid[row][col] != word.charAt(index)) return false;
        char temp = grid[row][col];
        grid[row][col] = '#';
        boolean found =  (helper(grid, word, index+1, row-1, col) ||
                helper(grid, word, index+1, row+1, col) ||
                helper(grid, word, index+1, row, col+1) ||
                helper(grid, word, index+1, row, col-1));
        grid[row][col] = temp;
        return found;
    }
}
