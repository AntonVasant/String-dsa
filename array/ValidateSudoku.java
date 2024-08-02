package array;

public class ValidateSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] == ' '){
                    for (char  c = '1'; c <= '9'; c++){
                        if (isValid(board,i,j,c)){
                            board[i][j] = c;
                            if (isValidSudoku(board)) return true;
                            board[i][j] = ' ';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char val) {

        for(int i = 0; i < 9; i++) {
            if(i != col && board[row][i] == val) {
                return false;
            }
        }

        for(int i = 0; i < 9; i++) {
            if(i != row && board[i][col] == val) {
                return false;
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if((i != row || j != col) && board[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}
