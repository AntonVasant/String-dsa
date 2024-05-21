package rescursion;

import java.util.ArrayList;

public class SubSequenceSum {
    public void subSequence(int[] array, int index, ArrayList<Integer> list,int n,int sum,int currentSum){
        if(index >= n){
            if(currentSum == sum){
                System.out.println(list);
            }
            return;
        }
        list.add(array[index]);
        currentSum+=array[index];
        subSequence(array,index+1,list,n,sum,currentSum);
        list.remove(list.size()-1);
        currentSum-=array[index];
        subSequence(array,index+1,list,n,sum,currentSum);
    }
}
