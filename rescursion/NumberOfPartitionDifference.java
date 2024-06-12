package rescursion;

public class NumberOfPartitionDifference {
    public static int partitions(int[] array,int index,int sum){
        return helper(array,0,sum);
    }
    public static int helper(int[] array,int index,int difference){
        int take = 0;
        if (index == array.length){
            if (difference == 0) return 1;
            return 0;
        }
        if (difference >= array[index])
         take = helper(array, index+1, difference-array[index]);
        int notTake = helper(array, index+1, difference);
        return take + notTake;
    }
}
