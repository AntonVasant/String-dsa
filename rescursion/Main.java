package rescursion;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String a[]){
         List<List<String>> list = new ArrayList<>();
         PalnidromePartitioning p = new PalnidromePartitioning();
         p.partitioning("aabb",0,list,new ArrayList<>());
        System.out.println(list);
    }
}
