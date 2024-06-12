package rescursion;

import java.util.ArrayList;
import java.util.List;

public class SplitMinimumDifference {
    static List<Integer> subset1 = new ArrayList<>();
    static List<Integer> subset2 = new ArrayList<>();
    static int minimumDifference = Integer.MAX_VALUE;
    public static void split(int[] array,int index){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        helper(list1,list2,array,index);
        for (int num : subset1)
            System.out.print(num+" ");
        System.out.println();
        for (int nm : subset2)
            System.out.print(nm+" ");
    }

    private static void helper(List<Integer> list1, List<Integer> list2, int[] array,int index) {
        if (index == array.length){
            int sum1 = sum(list1);
            int sum2 = sum(list2);
            int difference = Math.abs(sum1-sum2);
            if (difference < minimumDifference){
                minimumDifference = difference;
                subset1 = new ArrayList<>(list1);
                subset2 = new ArrayList<>(list2);
            }
            return;
        }
        list1.add(array[index]);
        helper(list1, list2, array, index+1);
        list1.remove(list1.size()-1);
        list2.add(array[index]);
        helper(list1, list2, array, index+1);
        list2.remove(list2.size()-1);
    }
    private static int sum(List<Integer> list){
        int total = 0;
        for (int num : list){
            total+= num;
        }
        return total;
    }
}
