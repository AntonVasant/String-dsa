package array;

public class MaximumSubArray {
    public int maximum(int[] array){
        int max = Integer.MAX_VALUE;
        int maxSoFar= array[0];
        for(int i=0;i< array.length;i++){
            max=Math.max(array[i],array[i]+max);
            maxSoFar = Math.max(maxSoFar,max);
        }
        return maxSoFar;
    }
}
