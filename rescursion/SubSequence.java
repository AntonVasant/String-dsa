package rescursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSequence {
    public void subSequence(int[] array, int index, ArrayList<Integer> list,int n){
        if(index>=n){
            System.out.println(list);
            return;
        }
        list.add(array[index]);
        subSequence(array,index+1,list,n);
        list.remove(list.size()-1);
        subSequence(array,index+1,list,n);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) { // without repeating subsets
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,ans,new ArrayList<>());
        return ans;
    }
    private void helper(int[] array,int index,List<List<Integer>> ans,List<Integer> list){

        ans.add(new ArrayList<>(list));
        for(int i =index;i<array.length;i++){
            if(i > index && array[i] == array[i-1]) continue;
            list.add(array[i]);
            helper(array,i+1,ans,list);
            list.remove(list.size()-1);
        }
    }
}
