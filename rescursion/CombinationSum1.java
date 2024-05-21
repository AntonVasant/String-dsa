package rescursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public void combination(int[] array,int target,int index,List<List<Integer>> lists,List<Integer> list){
        if(index == array.length){
            if(target == 0){
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        if(array[index] <= target){
            list.add(array[index]);
            combination(array,target-array[index],index,lists,list);
            list.remove(list.size()-1);
        }
        combination(array,target,index+1,lists,list);
    }
}
