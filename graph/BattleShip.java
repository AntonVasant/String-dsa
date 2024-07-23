package graph;

public class BattleShip {
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int total = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 'X'){
                    total++;
                    dfs(board,i,j);
                }
            }
        }
        return total;
    }

    private void dfs(char[][] board,int i,int j){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == ' ')
            return;
        board[i][i] = ' ';
        dfs(board, i+1, j);
        dfs(board, i, j+1);
    }
}
