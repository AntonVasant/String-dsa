package array;

import java.util.*;

public class OddAscendingEvenDescending {
    public static void sortArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // Compare and swap elements at even indices
            for (int j = i + 2; j < n; j += 2) {
                // For even indices, we want ascending order
                if (i % 2 == 0 && arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                // For odd indices, we want descending order
                if (i % 2 == 1 && arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void generatePrimeNumbers(int limit){
        List<Integer> list = new ArrayList<>();
        boolean[] isPrime = new boolean[limit+1];
        for (int i = 2; i <= limit; i++)
            isPrime[i] = true;
        for (int i = 2; i * i <= limit; i++){
            if (isPrime[i]){
                for (int j = i * i; j <= limit; j+= i)
                    isPrime[j] = false;
            }
        }

        for (int i = 0; i <= limit; i++){
            if (isPrime[i])
                list.add(i);
        }
        System.out.println(list);
    }
    public static void sortRemove(int[] arr){

        for (int i = 0; i < arr.length; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[minIndex])
                    minIndex = j;
                if (arr[i] == arr[j])
                    arr[j] = 0;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int minimumCostPath(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        int[][] dp = new int[row][col];
        for (int[] ar : dp)
            Arrays.fill(ar, Integer.MAX_VALUE);
        pq.offer(new int[]{0,0,grid[0][0]});
        dp[0][0]= grid[0][0];
        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            if (x == row - 1 && y == col-1)
                return dp[x][y];
            for (int[] arr : directions){
                int newX = arr[0] + x;
                int newY = arr[1]  + y;
                if (newX >= 0 && newX < row && newY >= 0 && newY < col){
                    int newCost = current[2] + grid[newX][newY];
                    if (newCost < dp[newX][newY]){
                        dp[newX][newY] = newCost;
                        pq.offer(new int[]{newX, newY, newCost});
                    }
                }
            }
        }

        return -1;
    }
    int longestIncreasingPath(int[][] matrix, int n, int m) {
        int[][] memo = new int[n][m];
       int ans = 0;
       for (int i = 0; i < n; i++){
           for (int j = 0; j < m; j++) {
               ans = Math.max(ans, longestIncreasingPathHelper(matrix,i,j,memo));
           }
       }
       return ans;
    }
    private int longestIncreasingPathHelper(int[][] grid, int i, int j, int[][] memo){
        if (memo[i][j] != 0) return memo[i][j];

        int maxLength = 1;
        for (int[] arr : directions){
            int x = i + arr[0];
            int y = j + arr[1];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[i][j] < grid[x][y]){
                maxLength = Math.max(maxLength, 1 + longestIncreasingPathHelper(grid, x, y, memo));
            }
        }

        memo[i][j] = maxLength;
        return memo[i][j];
    }
    public int[][] nearest(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                    visit[i][j] = true;
                }

            }
        }
        bfs(grid,queue);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (visit[i][j])
                    grid[i][j] = 0;
            }
        }
        return grid;
    }
    private void bfs(int[][] grid, Queue<int[]> queue){
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int row = grid.length;
        int col = grid[0].length;
        int steps = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] current = queue.poll();
                for (int[] ar : dir){
                    int x = current[0] + ar[0];
                    int y = current[1] + ar[1];
                    if (x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == 0){
                        grid[x][y] = steps;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
            steps++;
        }
    }
    public boolean is_Possible(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int[] src = new int[2];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 1){
                    src[0] = i;
                    src[1] = j;
                    break;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[row][col];
        queue.offer(src);
        visit[src[0]][src[1]] = true;
        return helper(grid, queue, visit);
    }
    private boolean helper(int[][] grid, Queue<int[]> queue, boolean[][] visit){
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            if (grid[current[0]][current[1]] == 2)
                return true;
            for (int[] arr : directions){
                int x = current[0] + arr[0];
                int y = current[1] + arr[1];
                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !visit[x][y] && grid[x][y] != 0){
                    visit[x][y] = true;
                    queue.offer(new int[]{x,y});
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
