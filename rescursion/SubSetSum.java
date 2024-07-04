package rescursion;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {
    public static void sums(int[] array){
        List<Integer> list = new ArrayList<>();
        helper(array,list,0,0);
        for (int m : list)
            System.out.println(m);
    }

    private static void helper(int[] array,List<Integer> list,int index,int sum){
        if (index == array.length){
            list.add(sum);
            return;
        }
        list.add(array[index]);
        helper(array, list, index+1, sum+array[index]);
        list.remove(list.size()-1);
        helper(array, list, index+1, sum);
    }
}
