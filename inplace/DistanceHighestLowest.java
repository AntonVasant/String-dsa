package inplace;

public class DistanceHighestLowest {

    int maxIndexDiff(int[] arr, int n) {
        int[] low = new int[n];
        int[] high = new int[n];
        low[0] = arr[0];
        for (int i = 1; i < n; i++)
            low[i] = Math.min(low[i-1],arr[i]);
        high[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--)
            high[i] = Math.max(high[i+1],arr[i]);
        int diff = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        while (i < n && j < n){
            if (low[i] <= high[j]){
                diff = Math.max(diff,j-i);
                j++;
            }
            else i++;
        }
        return diff;
    }
}
