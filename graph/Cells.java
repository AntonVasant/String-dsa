package graph;

public class Cells {
    int row;
    int col;
    Cells prev;

    public Cells(int row,int col,Cells prev){
        this.row = row;
        this.col = col;
        this.prev = prev;
    }

}
