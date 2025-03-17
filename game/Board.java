package game;

public class Board {

    String[][] grid;

    int[][] snakes;
    int[][] ladders;

    public Board(int[][] snakes, int[][] ladders){
        this.ladders = ladders;
        this.snakes = snakes;
        grid = new String[10][10];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                int num = i * 10 + j + 1;
                grid[i][j] = ""+num;
            }
        }
        int index = 1;
        for (int[] s : snakes){
            grid[s[0]][s[1]] = "s"+index;
            grid[s[2]][s[3]] = "s"+index;
            index++;
        }
        index = 1;
        for (int[] s : ladders){
            grid[s[0]][s[1]] = "l"+index;
            grid[s[2]][s[3]] = "l"+index;
        }
    }

    public void print(){
        for (int i = 9; i >= 0; i--){
            for (int j = 0; j < 10; j++){
                System.out.printf("| %-4s", grid[i][j]+" ");
            }
            System.out.println("|");
            System.out.println("-------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        Board board = new Board(new int[][]{{3,4,1,8}},new int[][]{{9,8,6,5}});
        board.print();
    }
}
