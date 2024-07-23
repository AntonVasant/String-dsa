package graph;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoomsKeys {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int room = queue.poll();
            for (int nextRoom : rooms.get(room)) {
                if (!visited[nextRoom]) {
                    visited[nextRoom] = true;
                    queue.offer(nextRoom);
                }
            }
        }
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
