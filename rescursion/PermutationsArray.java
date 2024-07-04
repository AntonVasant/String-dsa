package rescursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsArray {
    public static void permutations(int[] array){
        Set<List<Integer>> list = new HashSet<>();
        boolean[] flag = new boolean[array.length];
        List<Integer> lt = new ArrayList<>();
        helper(list,array,0,flag,lt);
        for (List<Integer> l : list)
            System.out.println(l);
    }

    private static void helper(Set<List<Integer>> list,int[] array,int index,boolean[] flags,List<Integer> ans){
        if (index == array.length){
            list.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < array.length; i++){
            if (!flags[i]){
                flags[i] = true;
                ans.add(array[i]);
                helper(list, array, index+1, flags, ans);
                flags[i] = false;
                ans.remove(ans.size()-1);
            }

        }
    }

}
