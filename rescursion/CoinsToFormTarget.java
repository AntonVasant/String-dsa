package rescursion;

import java.util.ArrayList;
import java.util.List;

public class CoinsToFormTarget {
    public static void coins(int[] array, int target, int index, List<Integer> list,List<List<Integer>> ans) {
        if(index == array.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (array[index] <= target){
            list.add(array[index]);
            coins(array,target-array[index],index,list,ans);
            list.remove(list.size()-1);
        }
        coins(array,target,index+1,list,ans);
    }
}
