package array;

import java.util.*;

public class NumbersAccordingToFrequency {
    public void frequency(int[] array){
        int index=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : array)
            map.put(num,map.getOrDefault(num,0)+1);
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for(Map.Entry<Integer,Integer> entry : list){
            int key = entry.getKey();
            int freq = entry.getValue();
             for(int i=0;i<freq;i++){
                 System.out.print(key+" ");
            }
        }

    }
}
