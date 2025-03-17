package array;

public class MaximumSumNonOverlappingSubArrays {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(helper(nums,firstLen,secondLen),helper(nums,secondLen,firstLen));
    }


    private int helper(int[] array,int first,int sec){
        int[] prefix = new int[array.length+1];
        int n = array.length;
        for (int i = 0; i < n; i++)
            prefix[i+1] = prefix[i]  + array[i];
        int maxF = 0;
        int sum = 0;
        for (int i = first + sec; i <= n; i++){
            maxF = Math.max(maxF,prefix[i-first] - prefix[i-first-sec]);
            sum = Math.max(sum,maxF + prefix[i] - prefix[i-first]);
        }
        return sum;
    }
}
/*
finding all possible sub array
 */