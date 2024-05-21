package rescursion;

import java.util.ArrayList;

public class SubSetSumStriver {
    public void subSet(int[] array, int sum, int index, int n){
        if(index == n){
            System.out.println(sum);
            return;
        }
        subSet(array,sum+array[index],index+1,n);
        subSet(array,sum,index+1,n);

    }
}
