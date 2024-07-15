package rescursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringWithOutAdjacentZero {
    public static void sequence(int n){
         List<String> list = new ArrayList<>();
         helper(n,0,list,"",true);
         for (String s : list){
             System.out.print(s+" ");
         }

    }

    private static void helper(int n,int index,List<String> list, String s,boolean zero){
        if (index == n){
            list.add(s);
            return;
        }
            if (zero){
                helper(n,index+1,list,s+"0",false);
            }
            helper(n,index+1,list,s+"1",true);
        }
}
