package dp;

import java.util.ArrayList;
import java.util.List;

public class SplitDifference {
    public static int minimum(int[] array,int index){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        helper(array,index,min,list1,list2);
        return min;
    }
    private static void helper(int[] array,int index,int minimumDifference,List<Integer> list1,List<Integer> list2){
        if (index == array.length){
            int sum1 = sum(list1);
            int sum2 = sum(list2);
            int current = Math.abs(sum1-sum2);
            if (current < minimumDifference)
                minimumDifference = current;
            return;
        }
        list1.add(array[index]);
        helper(array, index+1, minimumDifference, list1, list2);
        list1.remove(list1.size()-1);

        list2.add(array[index]);
        helper(array, index+1, minimumDifference, list1, list2);
        list2.remove(list2.size()-1);
    }
    private static int sum(List<Integer> ls){
        int total = 0;
        for (int m : ls)
            total += m;
        return total;
    }
}
