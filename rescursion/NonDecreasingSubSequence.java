package rescursion;

import graph.FreedomTrail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubSequence {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        helper(list,new ArrayList<>(),0,nums,-1);
        List<List<Integer>> list1 = new ArrayList<>();
        for (List<Integer> list11 : list){
            list1.add(new ArrayList<>(list11));
        }
        return list1;
    }

    private void helper(Set<List<Integer>> ans,List<Integer> list,int index,int[] array,int prev){
        if (index == array.length){
            if (list.size() >= 2){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (prev == -1 || array[index] >= prev){
            list.add(array[index]);
            helper(ans, list, index+1, array, array[index]);
            list.remove(list.size()-1);
        }
        helper(ans, list, index+1, array, prev);
    }
}
