package greedy;

import java.util.Arrays;

public class GroupIntervals {

    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        int k = 0;
        int j = 0;
        for (int i = 0; i < n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        int ans = 0;
        int max = 0;
        Arrays.sort(start);
        Arrays.sort(end);
        while (k < n){
            if (start[k] <=  end[j]){
                ans++;
                k++;
            }
            else {
                ans--;
                j++;
            }
            max = Math.max(max,ans);
        }
        return max;
    }
}
/*
You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].

You have to divide the intervals into one or more groups such that each interval is in exactly one group,
 and no two intervals that are in the same group intersect each other.

Return the minimum number of groups you need to make.

Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.



Example 1:

Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
Output: 3
Explanation: We can divide the intervals into the following groups:
- Group 1: [1, 5], [6, 8].
- Group 2: [2, 3], [5, 10].
- Group 3: [1, 10].
It can be proven that it is not possible to divide the intervals into fewer than 3 groups.
 */