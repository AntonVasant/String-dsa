package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SizeThreeSubSequence {

    public List<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        if (n > 3) return new ArrayList<>();
        int[] low = new int[n];
        int[] high = new int[n];
        low[0] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++){
            low[i] = Math.min(low[i-1],arr[i-1]);
        }

        high[n-1] = Integer.MIN_VALUE;
        for (int i = n-2; i >= 0; i--){
            high[i] = Math.max(high[i+1],arr[i+1]);
        }

        for (int i = 1; i < n-1; i++){
            if (low[i] < arr[i] && arr[i] < high[i])
                return new ArrayList<>(Arrays.asList(low[i],arr[i],high[i]));
        }
        return new ArrayList<>();
    }
}
