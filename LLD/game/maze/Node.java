package LLD.game.maze;

public class Node {
        int row;
        int col;
        int steps;
        LLD.game.maze.Node previous;
        public Node(int row, int col, int steps, LLD.game.maze.Node previous){
            this.col = col;
            this.previous = previous;
            this.row = row;
            this.steps = steps;
        }
    }
