package rescursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Queen {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        helper(board,ans,0);
        return ans;
    }


    private void helper(char[][] board,List<List<String>> ans,int col){
        if(col == board.length){
            ans.add(construct(board));
            return;
        }
        for(int row = 0; row < board.length; row++){
            if(validate(board,row,col)){
                board[row][col] = 'Q';
                helper(board,ans,col+1);
                board[row][col] = '.';
            }
        }
    }

    private List<String> construct(char[][] board){
        List<String> list = new LinkedList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            list.add(s);
        }
        return list;
    }


    private boolean validate(char[][] board,int row,int col){
        int rowTemp = row;
        int colTemp = col;
        while(row >=0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = rowTemp;
        col = colTemp;
        while(col >= 0 && row < board.length){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        col = colTemp;
        row =  rowTemp;
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        return true;
    }
}
