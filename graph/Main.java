package graph;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] a){
        ShortestDistanceBridge shortestDistanceBridge = new ShortestDistanceBridge();
        int[][] board = {{1,1,1,0,0},{1,1,0,0,1},{1,0,0,0,1},{1,0,0,1,1}};
        int n= shortestDistanceBridge.shortestBridge(board);
        System.out.println(n);
    }
}
