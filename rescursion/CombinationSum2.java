package rescursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {
    public void combination(int[] array,int target,int index,List<List<Integer>> lists,List<Integer> list){
            if(target == 0){
                lists.add(new ArrayList<>(list));
                return;
            }
        for(int i = index;i< array.length;i++){
            if(i > index && array[i] == array[i-1]) continue;
            if(array[i] > target) break;
            list.add(array[i]);
            combination(array,target-array[i],i+1,lists,list);
            list.remove(list.size()-1);

        }
    }
}
