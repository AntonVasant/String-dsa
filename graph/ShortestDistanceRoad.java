package graph;

import java.util.*;

public class ShortestDistanceRoad {


    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        int len = queries.length;
        int[] result = new int[len];
        for (int i = 0; i < n-1; i++)
            list.get(i).add(i+1);
        for (int i = 0; i < len; i++){
            int x = queries[i][0];
            int y = queries[i][1];
            list.get(x).add(y);
            result[i] = bfs(list, n);
        }
        return result;
    }


    private int bfs(List<List<Integer>> list, int n){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int[] distance = new int[n];
        while (!queue.isEmpty()){
            int current = queue.poll();
            for (int road : list.get(current)){
                if (!visited[road]){
                    queue.offer(road);
                    visited[road] = true;
                    distance[road] = distance[current]+1;
                    if (road == n-1)
                        return distance[n-1];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestDistanceRoad road = new ShortestDistanceRoad();
        System.out.println(Arrays.toString(road.shortestDistanceAfterQueries(5,new int[][]{{2,4},{0,2},{0,4}})));
    }
}
