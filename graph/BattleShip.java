package graph;

import java.util.*;

public class BattleShip {
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int total = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 'X'){
                    total++;
                    dfs(board,i,j);
                }
            }
        }
        return total;
    }

    private void dfs(char[][] board,int i,int j){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == ' ')
            return;
        board[i][i] = ' ';
        dfs(board, i+1, j);
        dfs(board, i, j+1);
    }



    /*
    You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
    For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence
     1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
    You will start at the bus stop source (You are not on any bus initially),
    and you want to go to the bus stop target. You can travel between bus stops by buses only. minimum number of buses required
         */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        int n = routes.length;
        for (int i = 0; i < n; i++){
            for (int num : routes[i]){
                if (!map.containsKey(num)){
                    map.put(num, new HashSet<>());
                }
                map.get(num).add(i);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{source, 0});
        boolean[] visit  = new boolean[n];
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int stop = cur[1];
            int place = cur[0];
            if (place == target)
                return stop;
            for (int index : map.get(place)){
                if (visit[index]) continue;
                for (int i : routes[index]){
                    if (!set.contains(i)){
                        set.add(i);
                        queue.offer(new int[]{i, stop + 1});
                    }
                }

                visit[index] = true;
            }
        }

        return -1;
    }

    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    //2503 leetcode
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length;
        int m = grid[0].length;
        int k = queries.length;
        int[] ans = new int[k];
        boolean[][] visited = new boolean[n][m];
        List<int[]> biggerCells = new ArrayList<>();
        int score = 0;
        biggerCells.add(new int[]{0,0});
        int[][] modifiedQueries = new int[k][2];
        for (int i = 0; i < k; i++){
            modifiedQueries[i][0] = i;
            modifiedQueries[i][1] = queries[i];
        }

        Arrays.sort(modifiedQueries, (a,b) -> a[1] - b[1]);
        for (int i = 0; i < k; i++) {
            int currentQuery = modifiedQueries[i][1];
            if (i > 0 && modifiedQueries[i-1][1] == modifiedQueries[i][1]){
                ans[modifiedQueries[i][0]] = ans[modifiedQueries[i-1][0]];
                continue;
            }

            Queue<int[]> queue = new LinkedList<>();

            Iterator<int[]> iterator = biggerCells.iterator();
            while (iterator.hasNext()){
                int[] current = iterator.next();
                if (currentQuery > grid[current[0]][current[1]]){
                    queue.add(current);
                    iterator.remove();
                }
            }

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                if (visited[current[0]][current[1]]) continue;
                visited[current[0]][current[1]] = true;
                score++;
                for (int[] dir : directions) {
                    int newX = dir[0] + current[0];
                    int newY = dir[1] + current[1];
                    if (newX < 0 || newY < 0 || newX >= n || newY >= m || visited[newX][newY]) continue;
                    if (grid[newX][newY] < currentQuery){
                        queue.offer(new int[]{newX, newY});
                    }
                    else {
                        biggerCells.add(new int[]{newX, newY});
                    }
                }
            }
            ans[modifiedQueries[i][0]] = score;
        }
        return ans;
    }
}
