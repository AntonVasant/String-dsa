package rescursion;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;

public class SubSequenceSum {
    public static boolean subSequenceOne(int[] array, int index, ArrayList<Integer> list,int n,int sum,int currentSum){
        if(index >= n){
            if(currentSum == sum){
                System.out.println(list);
                return true;
            }else return false;

        }
        list.add(array[index]);
        currentSum+=array[index];
        if(subSequenceOne(array,index+1,list,n,sum,currentSum))
            return true;
        list.remove(list.size()-1);
        currentSum-=array[index];
        if(subSequenceOne(array,index+1,list,n,sum,currentSum))
            return true;
        return false;
    }
    public static int numberOfSequence(int[] array, int index, ArrayList<Integer> list,int n,int sum,int currentSum){
        if(index >= n){
            if(currentSum == sum){
                return 1;
            }else return 0;

        }
        list.add(array[index]);
        currentSum+=array[index];
        int l = numberOfSequence(array,index+1,list,n,sum,currentSum);

        list.remove(list.size()-1);
        currentSum-=array[index];
        int r = numberOfSequence(array,index+1,list,n,sum,currentSum);
        return l+r;
    }

}
