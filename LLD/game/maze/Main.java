package LLD.game.maze;

public class Main {
    public static void main(String[] a){
        int[][] trigger = {{1,2},{3,6}};
        MazeRunner mazeRunner = new MazeRunner(10,trigger);
        mazeRunner.putThings(2,4,'M');
        mazeRunner.putThings(10,8,'T');
        mazeRunner.putThings(1,1,'M');
        mazeRunner.putThings(2,5,'M');
        mazeRunner.putThings(2,7,'M');
        mazeRunner.putThings(10,9,'M');
        mazeRunner.putThings(8,9,'M');
        mazeRunner.putThings(7,9,'M');
        mazeRunner.putThings(6,9,'M');
        mazeRunner.putThings(5,9,'M');
        mazeRunner.putThings(4,9,'M');
        mazeRunner.putThings(9,8,'M');
       int  n = mazeRunner.findShortestPath(9,9);
        System.out.println("Path is "+n+" steps long");
    }
}
