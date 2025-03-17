package matrix;

import javax.swing.event.ListDataEvent;
import java.util.*;

public class BrickWall {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer , Integer> map = new HashMap<>();
        for (List<Integer> list : wall){
            int count = 0;
            for (int i = 0; i < list.size()-1;i++){
                count += list.get(i);
                map.put(count,map.getOrDefault(count,0)+1);
            }
        }
        int max = 0;
        for (int n : map.values())
            max = Math.max(max,n);
        return wall.size()-max;
    }


    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] directions = {{1,1},{-1,-1},{-1,0},{0,-1},{0,1},{1,0},{1,-1},{-1,1}};
        List<List<Integer>> list = new ArrayList<>();
        int[][] board = new int[8][8];
        for (int[] arr : queens)
            board[arr[0]][arr[1]] = 1;
        for (int[] arr : directions){
                List<Integer> result = getCoordinate(board, king[0], king[1], arr[0],arr[1]);
                if (!result.isEmpty())
                    list.add(result);
        }
        return list;
    }

    private List<Integer> getCoordinate(int[][] board, int row, int col, int x, int y){
        if (row < 0 || col < 0 || row >= 8 || col >= 8)
            return Collections.emptyList();
        if (board[row][col] == 1)
            return new ArrayList<>(Arrays.asList(row, col));
        return getCoordinate(board, row+x, col+y, x, y);
    }

    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++){
            dp[i][0] = matrix[i][0];
            ans += dp[i][0];
        }

        for (int i = 0; i < m; i++){
            dp[0][i] = matrix[0][i];
            ans += dp[0][i];
        }

        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                if (matrix[i][j] == 1){
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]));
                    ans += dp[i][j];
                }

            }
        }

        return ans;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;
        int window;
        for (int i = 0; i < n; i++){
            int[] prefix = new int[m];
            window  = 0;
            for (int row = i; row < n; row++){
                window++;
                for (int col = 0; col < m; col++){
                    prefix[col] += mat[row][col];
                }
                if (window <= m){
                    if (largestSum(prefix, window, threshold))
                        ans = Math.max(ans, window);
                }
            }
        }
        return ans;
    }
    private boolean largestSum(int[] arr, int window, int threshold){
        int left = 0;
        int sum = 0;
        for (int i = 0; i < window; i++){
            sum += arr[i];
        }

        if (sum < threshold)
            return true;
        int right = window;
        while (right < arr.length){
            sum -= arr[left--];
            sum += arr[right++];
            if (sum < threshold)
                return true;
        }
        return false;
    }

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, k, 0}); // x, y, remaining k, steps

        // Visited array to track the least k left for a cell
        int[][] visited = new int[m][n];
        for (int[] row : visited) Arrays.fill(row, -1);
        visited[0][0] = k;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], remainingK = curr[2], steps = curr[3];

            // If we've reached the target
            if (x == m - 1 && y == n - 1) return steps;

            // Explore all directions
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // Check bounds
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int nextK = remainingK - grid[nx][ny];

                    // Only proceed if we can still eliminate the obstacle, or it's not an obstacle
                    if (nextK >= 0 && nextK > visited[nx][ny]) {
                        visited[nx][ny] = nextK;
                        queue.offer(new int[]{nx, ny, nextK, steps + 1});
                    }
                }
            }
        }

        return -1; // If the target is not reachable
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        boolean[][] visit = new boolean[n][m];
        visit[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,health});
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int currentHealth = current[2];
            if (row == n-1 && col == m-1)
                return true;
            for (int[] arr : directions){
                int x = arr[0] + row;
                int y = arr[1] + col;
                if (x >= 0 && y >= 0 && x < n && y < m){
                    int nextHealth = currentHealth - grid.get(x).get(y);
                    if (!visit[x][y]){
                        visit[x][y] = true;
                        queue.offer(new int[]{x,y,nextHealth});
                    }
                }
            }
        }
        return false;
    }
    public static void rearrangeInPlace(int[] arr) {
        Arrays.sort(arr); // Sort the array

        int n = arr.length;
        for (int i = 1; i < n; i += 2) {
            int temp = arr[i];
            arr[i] = arr[n - 1];
            arr[n - 1] = temp;
            n--;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        boolean left;
        boolean right;
        for (int i = 0; i < n; i++){
            left = i == 0 || i > 0 && seats[i-1] == 0;
            right = i == n-1 || i < n-1 && seats[i+1] == 0;
            if (left && right && seats[i] == 0){
                m--;
                seats[i] = 1;
            }
        }
        return m <= 0;
    }
    static boolean lemonadeChange(int N, int[] bills) {
        int fives = 0;
        int tens = 0;
        for (int num : bills){
            if (num == 5)
                fives++;
            else if (num == 10){
                if (fives < 1)
                    return false;
                fives--;
                tens++;
            }
            else {
                if (tens >= 1 && fives >= 1){
                    tens--;
                    fives--;
                }
                else if (fives >= 3){
                    fives -= 3;
                }
                else return false;

            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(lemonadeChange(5, new int[]{5, 5, 10, 10, 20}));
    }

}
