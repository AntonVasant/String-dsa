package rescursion;

public class NumberOfSubsetSum {
    public static int subsets(int[] array,int target,int index){
        if (index == array.length && target == 0) return 1;
        if (index == array.length) return 0;
        int take = 0;
        if (array[index] <= target){
            take = subsets(array, target-array[index], index+1);
        }
        int nonTake = subsets(array, target, index+1);
        return take+nonTake;
    }
}
