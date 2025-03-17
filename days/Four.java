package days;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
we are doing divide and conquer
 */
public class Four {
    /*
    painters painting
     */
    int findOnce(int[] arr, int n){
        if (n == 1) return arr[0];
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[n-1] != arr[n-2])
            return arr[n-1];
        int low = 1;
        int high = n-1;
        while (low < high){
            int mid = (low + high)/2;
            if (arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1])
                return arr[mid];
            else if (mid % 2 == 0){
                if (arr[mid] != arr[mid+1])
                    high = mid;
                else low = mid;
            }
            else {
                if (arr[mid] != arr[mid-1])
                    high = mid;
                else low  = mid;
            }
        }
        return -1;
    }
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int n = arr1.length;
        int count = 0;
        int prev = 0;
        int current = 0;
        while (count <= n){
            prev = current;
            if (j >= n || i < n && arr1[i] < arr2[j])
                current = arr1[i++];
            else current = arr2[j++];
            count++;
        }
        return current + prev;
    }
    public long PowMod(long x, long n, long m){
        if (x == 0) return 1;
        if (n == 1) return 0;

        long half = PowMod(x/2, n,m) % m;
        if (n % 2 == 0)
            return half * half;
        else return ((half * half) % m * x % m)  % m;
    }
    static int Search(int[] array, int target){
        int n = array.length;
        int low = 0;
        int high = n-1;
        while (low <= high){
            int mid = (low + high)/2;
            if (array[mid] == target)
                return mid;
            if (array[low] <= array[mid]){
                if (target >=  array[low] && target < array[mid])
                    high = mid -1;
                else low = mid +1;
            }
            else {
                if (target > array[mid] && target < array[high])
                    low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
    static int minCandy(int N, int[] ratings) {
        int[] arr1 = new int[N];
        Arrays.fill(arr1, 1);
        for (int i = 1; i < N; i++){
            if (ratings[i] > ratings[i-1])
                arr1[i] = arr1[i-1]+1;
        }

        for (int i = N-2; i >= 0; i--){
            if (ratings[i] > ratings[i+1])
                arr1[i] = Math.max(arr1[i], arr1[i+1]+1);
        }
        return Arrays.stream(arr1).sum();
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int m = grid.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        queue.offer(new int[]{0,0,health});
        visit[0][0] = true;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int life = cur[2];
            if (row == n -1 && col == m -1)
                return true;
            for (int[] arr : dir){
                int x = row + arr[0];
                int y = col + arr[1];
                if (x == n || y == m || x < 0 || y < 0 || life < 1 || visit[x][y])
                    continue;
                if (grid.get(x).get(y) == 1)
                    life--;
                queue.offer(new int[]{x,y,life});
                visit[x][y] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Four four = new Four();
        
    }
}
