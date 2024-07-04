package rescursion;

import dp.InterleavingStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SplitEqualSum {
    static List<Integer> l1 = new ArrayList<>();
    static List<Integer> l2 = new ArrayList<>();
    static int minium = Integer.MAX_VALUE;
    public static void equalSum(int[] array){
        Set<List<Integer>> ans  = new HashSet<>();
        helper(array,0,ans,new ArrayList<>(),new ArrayList<>(),0,0);
        System.out.println(l1);
        System.out.println(l2);
    }

    private static void helper(int[] array,int index, Set<List<Integer>> ans,
                               List<Integer> list1,List<Integer> list2,int sum,int sum2){
        if (index == array.length){
            if (Math.abs(sum-sum2) < minium){
                minium = Math.abs(sum - sum2);
                  l1 = new ArrayList<>(list1);
                  l2 = new ArrayList<>(list2);
            }
            return;
        }
        list1.add(array[index]);
        helper(array, index+1, ans, list1, list2, sum + array[index], sum2);
        list1.remove(list1.size()-1);
        list2.add(array[index]);
        helper(array, index+1, ans, list1, list2, sum, sum2+array[index]);
        list2.remove(list2.size()-1);
    }
}
