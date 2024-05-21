package rescursion;

import java.util.List;

public class SubSetSum1 {
    public void subSet(int[] array, int target, List<Integer> list,int index,int currentSum){
        if(index >= array.length){
            if(target == currentSum){
                System.out.println(list);
            }
            return;
        }
        if(array[index] <= target){
            list.add(array[index]);
            currentSum+=array[index];
            subSet(array,target,list,index+1,currentSum);
            list.remove(list.size()-1);
            currentSum-=array[index];
            subSet(array,target,list,index+1,currentSum);
        }
    }
}
