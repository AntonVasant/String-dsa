package rescursion;

public class SudokoSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <='9'; c++){
                        if(validate(board,i,j,c)){
                            board[i][j] = c;
                            if(solve(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean validate(char[][] board,int row,int col,char c){
        for(int i = 0; i < board.length;i++){
            if(board[i][col] == c || board[row][i] == c)
                return false;
        }
        int rowStart = (row/3) * 3;
        int colStart = (col/3) * 3;
        for(int i = rowStart; i < rowStart +3; i++){
            for(int j = colStart; j < colStart +3;j++){
                if(board[i][j] == c) return false;
            }
        }
        return true;
    }
}
