package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String cur = "";
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 3; j++)
               cur += board[i][j];
        }
        if (cur.equals(target)) return 0;
        int[][] dir = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(cur);
        queue.offer(cur);
        int moves = 0;
        while (!queue.isEmpty()){
           int size = queue.size();
           for (int i = 0; i <size; i++){
               String current = queue.poll();
               int index = current.indexOf("0");
               for (int n : dir[index]){
                   String next = swap(current,index,n);
                   if (next.equals(target)) return moves;
                   if (!visited.contains(next)){
                       visited.add(next);
                       queue.offer(next);
                   }
               }
           }
            moves++;
        }
        return -1;
    }

    private String swap(String s,int i,int j){
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}
