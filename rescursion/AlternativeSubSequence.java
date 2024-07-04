package rescursion;

public class AlternativeSubSequence {
    public static int subSequence(int[] array){
        int inc = helper(array,0,-4,true);
        int dec = helper(array,0,Integer.MAX_VALUE,false);
        return Math.max(inc,dec);
    }

    private static int helper(int[] array,int index,int prev,boolean isIncreasing){
        if (index == array.length) return 0;

        int take = 0;
        if (isIncreasing){
            if (array[index] > prev){
                take = 1 + helper(array, index+1, array[index], false);
            }
        }else {
            if (array[index] < prev){
                take = 1 + helper(array, index+1, array[index], true);
            }
        }
        int nonTake = helper(array, index+1, prev, isIncreasing);
        return Math.max(take,nonTake);
    }
}
