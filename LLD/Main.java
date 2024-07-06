package LLD;

import java.util.Scanner;

public class Main {
    public static void main(String a[]){
        int[][] maze = {
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 0, 4}
        };
        int n = NumberOfStepsRat.minimumSteps(maze,0,0);
        System.out.println(n);
    }
}
