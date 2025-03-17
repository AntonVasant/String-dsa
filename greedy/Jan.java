package greedy;

import java.util.*;

public class Jan {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int totalDays = 0;

        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            totalDays += duration;
            maxHeap.add(duration);

            if (totalDays > lastDay) {
                totalDays -= maxHeap.poll();
            }
        }

        return maxHeap.size();
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : map.keySet()){
            int freq = map.get(num);
            if (freq > 0){
                for (int i = 1; i < k; i++){
                    if (map.getOrDefault(num + i, 0) < freq)
                        return false;
                    map.put(num + i, map.get(num + i) - freq);
                }
            }
        }
        return true;
    }


    public int minimumSwap(String s1, String s2) {
        int x = 0;
        int y = 0;
        int count;
        int n = s1.length();
        int m = s2.length();
        if (m != n)
            return -1;
        for (int i = 0; i < n; i++){
            if (s1.charAt(i) == 'X' && s2.charAt(i) == 'Y')
                x++;
            else if (s1.charAt(i) == 'Y' && s2.charAt(i) == 'X')
                y++;
        }

        if (x % 2 != y % 2)
            return -1;
        count = x/2 + y/2;
        if (x % 2 != 0)
            count += 2;
        return count;
    }


    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> list = new ArrayList<>();
        int n = colsum.length;
        Integer[] upperArr = new Integer[n];
        Integer[] lowerArr = new Integer[n];
        Arrays.fill(upperArr, 0);
        Arrays.fill(lowerArr, 0);
        for (int i = 0; i < n; i++){
            if (colsum[i] == 2){
                upperArr[i] = 1;
                lowerArr[i] = 1;
                upper--;
                lower--;
            }
        }

        for (int i = 0; i < n; i++){
            if (colsum[i] == 1){
                if (lower > 0){
                    lowerArr[i] = 1;
                    lower--;
                }
                else if (upper > 0){
                    upperArr[i] = 1;
                    upper--;
                }
                else return list;
            }
        }

        if (upper != 0 || lower != 0)
            return list;
        list.add(Arrays.asList(upperArr));
        list.add(Arrays.asList(lowerArr));
        return list;
    }


    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int  row = rowSum.length;
        int col = colSum.length;
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;
    }

    public static int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= (int) (len * count);
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }

    public int minimumOperations(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cost = 0;
        for (int i = 0; i < m; i++){
            int max = grid[0][i];
            for (int[] ints : grid) {
                if (ints[i] > max) {
                    cost += ints[i] - max + 1;
                    max = ints[i];
                }
            }
        }
        return cost;
    }
    public static void main(String[] args) {

    }
}
