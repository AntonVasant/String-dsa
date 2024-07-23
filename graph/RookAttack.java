package graph;

public class RookAttack {
    public int numRookCaptures(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int posx = 0;
        int posy = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'R') {
                    posx = i;
                    posy = j;
                    break;
                }
            }
        }
        return dfs(board, posx, posy, row, col, -1, 0) +
                dfs(board, posx, posy, row, col, 0, -1) +
                dfs(board, posx, posy, row, col, 1, 0) +
                dfs(board, posx, posy, row, col, 0, 1);
    }

    private int dfs(char[][] board, int i, int j, int row, int col, int a, int b) {
        i += a;
        j += b;
        while (i >= 0 && j >= 0 && i < row && j < col && board[i][j] != 'B') {
            if (board[i][j] == 'p') return 1;
            i += a;
            j += b;
        }
        return 0;
    }
}
