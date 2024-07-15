package array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKTimesRepeatedNumbers {
   public static void repeated(int[] array){
       Map<Integer,Integer> map = new HashMap<>();
       for(int i = 0; i < array.length; i++){
           map.put(array[i], map.getOrDefault(array[i],0)+1);
       }
       PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() -  a.getValue());
       pq.addAll(map.entrySet());
       for (int i = 0; i < 3; i++){
           System.out.println(pq.poll());
       }
   }

}
