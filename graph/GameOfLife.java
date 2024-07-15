package graph;

public class GameOfLife {
    public void game(int[][] board){
        int row = board.length;
        int col = board[0].length;
        int[][] updates = new int[row][col];
        for (int i = 0; i < row ; i++){
            for (int j = 0; j < col; j++){
                 int alive = countAdjacent(board,i,j);
                 if (alive > 3 || alive < 2){
                     updates[i][j] = 0;
                 }else updates[i][j] = 1;
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                System.out.print(updates[i][j]+" ");
            }
            System.out.println();
        }
    }

    private int countAdjacent(int[][] board,int i,int j){
        int[][] directions = {{0,1},{1,0},{1,1},{-1,1},{0,-1},{-1,-1},{1,-1},{-1,0}};
        int row = board.length;
        int col = board[0].length;
        int count = 0;
        for (int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0 || x >= row || y >= col || board[x][y] != 1) continue;
            count++;
        }
        return count;
    }
}
