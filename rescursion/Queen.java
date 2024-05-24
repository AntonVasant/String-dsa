package rescursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Queen {
    public void queen(){
        int n = 8;
        List<List<String>> res = solveQueen(n);
        for (List<String> list : res){
            for (String s : list){
                System.out.println(s+" ");
            }
            System.out.println();
        }
    }
    private List<List<String>> solveQueen(int n){
        char[][] board = new char[n][n];
        List<List<String>> res = new ArrayList<>();
        for (int i =0;i<n;i++){
            for (int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        dfs(res,board,0);
        return res;
    }
    private void dfs(List<List<String>> res,char[][] board,int col){
        if(col == board.length){
            res.add(construct(board));
            return;
        }
        for (int i=0;i< board.length;i++){
            if(validate(i,col,board)){
                board[i][col] = 'Q';
                dfs(res,board,col+1);
                board[i][col] = '.';
            }
        }

    }
    private boolean validate(int row,int col,char[][] board){
        int tempRow =row;
        int tempCol = col;
        while (row >=0 && col>=0){
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }
        row = tempRow;
        col = tempCol;
        while (col >= 0){
            if (board[row][col] == 'Q')
                return false;
            col--;
        }
        row = tempRow;
        col = tempCol;
        while (col >= 0 && row< board.length){
            if (board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }
        return true;
    }
    private List<String> construct(char[][] board){
        List<String> res = new LinkedList<>();
        for (int i=0;i< board.length;i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
