package prefixsum;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Jan {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;;
        int[] prefix = new int[n];
        int[] ans = new int[queries.length];
        int m = queries.length;
        int count = 0;
        for (int i = 0; i < n; i++){
            String s = words[i];
            int len = s.length();
            if (isVowel(s.charAt(0)) && isVowel(s.charAt(len-1)))
                count++;
            prefix[i] = count;
        }


        for (int i = 0; i < m; i++){
            int[] cur = queries[i];
            int minIndex = cur[0] == 0 ? 0 : prefix[cur[0]-1];
            ans[i] = prefix[cur[1]] - minIndex;
        }

        return ans;
    }


    private boolean isVowel(char c){
        return "aeiou".indexOf(c) != -1;
    }
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n;
        int ans = 0;
        while (low <= high){
            int mid = (low + high)/2;
            if (isValid(citations, mid)){
                ans = mid;
                low = mid + 1;
            }
            else high = mid -1;
        }
        return ans;
    }

    private static boolean isValid(int[] arr, int limit){
        int currentSum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++){
            if (arr[i] >= limit)
                currentSum++;
            if (currentSum >= limit)
                return true;
        }
        return false;
    }
//    public void wiggleSort(int[] nums) {
//
//    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) ->
        {
            if (a[0] == b[0])
                return 0;
            else return b[0] - a[0];
        });

        return people;
    }


    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder builder = new StringBuilder();
        for (char c : order.toCharArray()){
            if (map.containsKey(c)){
                int times = map.get(c);
                for (int i = 0; i < times; i++)
                    builder.append(c);
                map.remove(c);
            }
        }

        for (char c : s.toCharArray()){
            if (map.containsKey(c)){
                int times = map.get(c);
                for (int i = 0; i < times; i++)
                    builder.append(c);
                map.remove(c);
            }
        }

        return builder.toString();
    }
    public int numFriendRequests(int[] ages) {
        // Sort the array of ages in ascending order
        Arrays.sort(ages);
        int totalRequests = 0;  // Variable to store the total number of friend requests
        int n = ages.length;  // Number of people in the list
        int[] ageFrequency = new int[121];  // Array to store the frequency of each age from 1 to 120

        // Iterate over each person's age in the sorted list
        for (int i = 0; i < n; i++) {
            int currentAge = ages[i];

            // Skip people aged 14 or younger (invalid for sending friend requests)
            if (currentAge <= 14) continue;

            // Find the lower bound using binary search to get the valid age range for sending requests
            int left = 0, right = i - 1, lowerBoundIndex = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (ages[mid] > (currentAge / 2 + 7)) {
                    right = mid - 1;
                    lowerBoundIndex = mid;  // Store the index of the lower bound
                } else {
                    left = mid + 1;
                }
            }

            // Calculate valid friend requests:
            // - The number of people in the valid age range for friend requests
            // - The number of people of the same age as the current person
            if (lowerBoundIndex != -1) {
                totalRequests += (i - lowerBoundIndex);  // Requests to people in the valid range
                totalRequests += ageFrequency[currentAge];  // Requests to people of the same age
            }

            // Update the frequency of the current age (to be used for subsequent iterations)
            ageFrequency[currentAge]++;
        }

        return totalRequests;  // Return the total number of valid friend requests
    }


    public static int waysToSplitArray(int[] nums) {
        int n  = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i-1] + nums[i];

        int count = 0;
        int max = prefix[n-1];
        for (int i = 0; i < n-1; i++) {
            if (prefix[i] > max - prefix[i]){
                count++;

            }

        }
        return count;

    }
    public boolean canTransform(String start, String result) {
        if (start.replace("X", "").length() != result.replace("X", "").length()) {
            return false;
        }
        int n = start.length();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (start.charAt(i) == 'L'){
                while (j < n && result.charAt(j) != 'L')
                    j++;

                if (j > i) return false;
                j++;

            }
            else if (start.charAt(i) == 'R'){
                while (j < n && result.charAt(j) == 'R')
                    j++;
                if (j < i) return false;
                j++;
            }
        }
        return true;
    }
//    public int expressiveWords(String s, String[] words) {
//
//    }
//
//    private boolean isValid(String s, String original){
//        int i = 0;
//        int j = 0;
//        int n = s.length();
//        int m = original.length();
//        while (i < m && j < n){
//            if (s.charAt(i) == original.charAt(j)){
//                int len1 = getRepeating(s, i);
//                int len2 = getRepeating(original, j);
//                if (len1 > len2) return false;
//            }
//        }
//    }


    /*
    Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed
    , and the character will be typed 1 or more times.

    You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name,
    with some characters (possibly none) being long pressed.
     */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        int n = name.length();
        int m = typed.length();
        while (i < n && j < m){
            if (name.charAt(i) != typed.charAt(j)) return false;
            int len1 = getRepeating(name, i);
            int len2 = getRepeating(typed, j);
            if (len1 > len2) return false;
            i += len1;
            j += len2;
        }

        return i >= n && j >= m;
    }

    private int getRepeating(String s, int i){
        int j = i;
        while (j < s.length() && s.charAt(j) == s.charAt(i))
            j++;
        return j - i;
    }

    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n-2; i++){
            int low = i + 1;
            int high = n-1;
            int sum = target - arr[i];
            while (low < high){
                if (arr[low] + arr[high] > sum) high--;
                else if (arr[low] + arr[high] < sum) low++;
                else {
                    int count1 = 1;
                    int count2 = 1;
                    if (arr[low] == arr[high]){
                        int len  = high - low + 1;
                        count += (len * (len - 1))/2;
                        break;
                    }

                    while (low < high && arr[low] == arr[low + 1]){
                        low++;
                        count1++;
                    }

                    while (high > low && arr[high] == arr[high - 1]){
                        high++;
                        count2++;
                    }

                    count += count1 * count2;
                    high--;
                    low++;
                }
            }
        }
        return count;
    }
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length;
        int m = secondList.length;
        int i = 0;
        int j = 0;

        if (n == 0 || m == 0)
            return new int[][]{};
        List<int[]> list = new ArrayList<>();

        while (i < n && j < m){
            int[] first = firstList[i];
            int[] sec = secondList[j];
            if (sec[1] < first[0] || first[1] < sec[0]){
                if (first[1] < sec[0])
                    i++;
                if (sec[1] < first[0]) j++;
            }
            else {
                int firstMin = Math.max(first[0], sec[0]);
                int secMin = Math.min(first[1], sec[1]);
                list.add(new int[]{firstMin,secMin});
                if (first[1] > sec[1]) j++;
                else i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        for (String s : queries){
            list.add(isMatching(s, pattern));
        }
        return list;
    }

    private boolean isMatching(String query, String pattern){
        int i = 0;
        int j = 0;
        int n = query.length();
        int m = pattern.length();
        while (i < n && j < m){
            char pat = pattern.charAt(j);
            char mat = query.charAt(i);
            if (Character.isUpperCase(mat) && pat != mat)
                return false;
            i++;
            if (pat == mat){
                j++;
            }
        }

        if (j < m) return false;
        while (i < n){
            if (Character.isUpperCase(query.charAt(i++)))
                return false;
        }
        return true;
    }


    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int max = 0;
        for (String s : words){
            map.put(s, 1);
            for (int i = 0; i < s.length(); i++){
                String str = s.substring(0,i) + s.substring(i + 1);
                if (map.containsKey(str)){
                    map.put(s, Math.max(map.get(str) + 1 , map.get(s)));
                    max = Math.max(max, map.get(s));
                }
            }
        }
        return max;
    }


    public static void duplicateZeros(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++){
            if (arr[i] == 0 && i < n -1){
                for (int j = n-1 ; j > i; j--){
                    arr[j] = arr[j-1];
                }
                arr[i++] = 0;

            }
        }
    }

    public static int longestDecomposition(String text) {
        int right = text.length()-1;
        int left = 0;
        int count = 0;
        int leftPointer = 0;
        int rightPointer = right;
        while (left <= right){
            while (left < right && text.charAt(right) != text.charAt(left))
                right--;

            if (left == right) return count + 1;
            if (text.substring(right, rightPointer + 1).equals(text.substring(leftPointer, leftPointer +   rightPointer - right + 1))){
                count += 2;
                leftPointer = left + text.substring(right, rightPointer+1).length();
                rightPointer = right-1;
                left = leftPointer;
            }
            right--;
        }

        return count;
    }


    //TODO
    public String lastSubstring(String s) {
        int i = 0;
        int j = 1;
        int k = 0;
        int n = s.length();
        char[] ca = s.toCharArray();

        while (j + k < n){
            if (ca[i + k] == ca[j + k]) {
                k++;
            } else if (ca[i + k] > ca[j + k]) {
                j = j + k + 1;
                k = 0;
            } else {
                i = Math.max(i + k + 1, j);
                j = i + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }

    int countDistinctIslands(int[][] grid) {
        Set<Set<String>> uniqueIslands = new HashSet<>();
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    Set<String> shape = new HashSet<>();
                    dfs(grid, visited, i, j, i, j, shape);
                    uniqueIslands.add(shape);
                }
            }
        }
        return uniqueIslands.size();
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j, int baseRow, int baseCol, Set<String> shape) {
        int rows = grid.length, cols = grid[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        shape.add((i - baseRow) + "," + (j - baseCol));

        dfs(grid, visited, i + 1, j, baseRow, baseCol, shape); // Down
        dfs(grid, visited, i - 1, j, baseRow, baseCol, shape); // Up
        dfs(grid, visited, i, j + 1, baseRow, baseCol, shape); // Right
        dfs(grid, visited, i, j - 1, baseRow, baseCol, shape); // Left
    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        visit[source[0]][source[1]] = true;
        queue.offer(new int[]{source[0],source[1],0});
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int step = current[2];
            if (row == destination[0] && col == destination[1]) return step;
            for (int[] arr : dir){
                int x = row + arr[0];
                int y = col + arr[1];
                if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1 && !visit[x][y]){
                    visit[x][y] = true;
                    queue.offer(new int[]{x,y, step + 1});
                }
            }
        }
        return -1;
    }
    public int MaxConnection(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 2;
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1){
                    int area = countArea(grid,i,j,count);
                    map.put(count, area);
                    maxArea = Math.max(maxArea, area);
                    count++;
                }
            }
        }


        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0){
                    Set<Integer> set = new HashSet<>();
                    int area = 0;
                    for (int[] arr : dir){
                        int x = i + arr[0];
                        int y = j + arr[1];
                        if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] >= 2 && !set.contains(grid[x][y])){
                            set.add(grid[x][y]);
                            area += map.getOrDefault(grid[x][y], 0);
                        }
                    }
                    maxArea = Math.max(maxArea, area + 1);
                }
            }
        }
        return maxArea;
    }
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private int countArea(int[][] grid, int i, int j, int number){
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != 1)
            return 0;
        int ans = 1;
        grid[i][j] = number;
        for (int[] a : dir)
            ans += countArea(grid,i + a[0], j + a[1], number);
        return ans;
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix[0].length;
        int m = matrix.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++){
            int[] prefix = new int[n];
            for (int j = i; j < m; j++){
                for (int col = 0; col < n; col++){
                    prefix[col] += matrix[j][col];
                }

                int area = maxSubArray(prefix, k);
                ans = Math.max(ans, area);
                if (area == k) return k;

            }
        }
        return ans;
    }

    public int maxSubArray(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int j : arr) {
            currSum += j;
            Integer ceilValue = set.ceiling(currSum - k);
            if (ceilValue != null) {
                max = Math.max(max, currSum - ceilValue);
            }
            set.add(currSum);
        }
        return max;

    }
    public static void main(String[] args) throws IOException {
        try(PrintWriter writer = new PrintWriter("file.txt")){
            double balance = 9999.00;
            String name = "Mershesha";
            String spouse = "Anton";
            String profession = "Engineer";

            writer.printf("Balance: %.2f | Name : %s | Spouce : %s | Profession : %s%n", balance,name,spouse,profession);
        }
    }
}
