package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMatrixSumEqualsTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        for (int i = 0; i < n; i++){
            int[] prefix = new int[m];
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++){
                    prefix[k] += matrix[j][k];
                }
                count += helper(prefix,target);
            }
        }
        return count;
    }

    private int helper(int[] array,int target){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for (int n : array){
            sum += n;
            if (map.containsKey(sum - target))
                count += map.get(sum-target);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
