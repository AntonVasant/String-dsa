package LLD.game.maze;

import java.util.LinkedList;
import java.util.Queue;


public class MazeRunner {
    char[][] maze;
    int[][] trigger;
    public MazeRunner(int n,int[][] trigger){
        maze = new char[n][n];
        this.trigger = trigger;
    }

    public void printMaze(){
        for (char[] c : maze){
            for (char ch : c)
                System.out.print(ch+" ");
            System.out.println();
        }
    }

    private void tracePath(Node node){
        while (node != null){
            maze[node.row][node.col] = 'P';
            node = node.previous;
        }
        printMaze();
    }

    public void putThings(int row,int col,char ch){
        row--;
        col--;
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) return;
        maze[row][col] = ch;
    }
    public int findShortestPath(int row,int col){
        row--;
        col--;
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || maze[row][col] =='M'){
            System.out.println("failed");
            return -1;
        }
        Queue<Node> queue = new LinkedList<>();
        int n = maze.length;
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] visited = new boolean[n][n];
        queue.offer(new Node(row,col,0,null));
        while (!queue.isEmpty()){
            Node current = queue.poll();
            for (int[] dir : directions){
                int x = dir[0] + current.row;
                int y = dir[1] + current.col;
                if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y] && maze[x][y] != 'M'){
                    visited[x][y] = true;
                    if (maze[x][y] == 'T'){
                        System.out.println("Path Found");
                        tracePath(current);
                        return current.steps+1;
                    }
                    queue.offer(new Node(x,y,current.steps+1,current));
                }
            }
        }
        return -1;
    }
}
