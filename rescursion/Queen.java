package rescursion;

import java.util.ArrayList;
import java.util.List;

public class Queen {
    public void queen(){
        List<List<String>> list = solveQueen(4);
        for(List<String> li : list){
            for(String s : li){
                System.out.println(s+" ");
            }
            System.out.println();
        }
    }
    private List<List<String>> solveQueen(int n){
        char[][] board = new char[n][n];
        List<List<String>> list  = new ArrayList<List<String>>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        dfs(0,board,n,list);
        return list;
    }
    private void dfs(int cols,char[][] board,int n,List<List<String>> list){
        if(cols == n){
            list.add(construct(board));
        }
        for(int row =0;row<n;row++){
            if(validate(board,row,cols)) {
                board[row][cols] = 'Q';
                dfs(cols+1,board,n,list);
                board[row][cols] = '.';
            }
        }
    }
    private static List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }
    private boolean validate(char[][] board,int row,int col){
        int tempRow = row;
        int tempCol = col;
        while(row >= 0 && col >= 0){
            if (board[row][col] == 'Q')
                return  false;
            row--;
            col--;
        }
        col = tempCol;
        row = tempRow;
        while (col >= 0){
            if(board[row][col] ==  'Q')
                return false;
            col--;
        }
        row = tempRow;
        col = tempCol;
        while (col >= 0 && row < board.length){
            if(board[row][col] == 'Q')
                return false;
            col--;
            row++;
        }
        return true;
    }
}
