package dp;

public class PartitionEqualSum {
    public static boolean equal(int[] array,int index){
        int total = 0;
        for (int num : array){
            total += num;
        }
        if (total % 2 == 1) return false;
        return helper(array,index,total/2);
    }
    public static boolean helper(int[] array,int index,int sum){
        if (array.length == index){
            if (sum == 0) return true;
            return false;
        }
        return helper(array, index+1, sum) || helper(array, index+1, sum - array[index]);
    }
}
