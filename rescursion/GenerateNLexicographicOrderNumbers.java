package rescursion;

import java.util.*;

public class GenerateNLexicographicOrderNumbers {

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++){
            helper(i,n,list);
        }
        return list;
    }


    private static void helper(int current, int n, List<Integer> list){
        if (current > n) return;
        list.add(current);

        for (int i = 0; i < 10; i++){
            int next = current * 10 + i;
            helper(next, n, list);
        }
    }





    static int findFloor(int[] arr, int k) {
        int n = arr.length;
        int ans = -1;
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            if (arr[i] <= k){
                if (arr[i] > temp){
                    ans = i;
                    temp = arr[i];
                }
            }
        }
        return ans;
    }


    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++){
            pair[i][0] = start[i];
            pair[i][1] = end[i];
        }
        Arrays.sort(pair, (a,b) -> a[0] - b[0]);
        int lastEnd = pair[0][1];
        int count = 1;
        for (int i = 1; i < n; i++){
            if (pair[i][0] >= lastEnd){
                count++;
                lastEnd = pair[i][1];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(lexicalOrder(34));
    }
}
