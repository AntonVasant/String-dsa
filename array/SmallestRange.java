package array;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Element{
    int value;
    int listIndex;
    int index;
    public Element(int value,int listIndex,int index){
        this. value = value;
        this.listIndex = listIndex;
        this.index = index;
    }
}
public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        int max = Integer.MIN_VALUE;
        PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        for (int i = 0; i < nums.size(); i++){
            pq.offer(new Element(nums.get(i).get(0),i,0));
            max = Math.max(max,nums.get(i).get(0));
        }
        int  start = 0;
        int end = Integer.MAX_VALUE;
        while (pq.size() == nums.size()){
            Element current = pq.poll();
            int currentValue = current.value;
            if (max - currentValue < end - start){
                end = max;
                start = currentValue;
            }
            if (nums.get(current.listIndex).size() > current.index+1){
                int value = nums.get(current.listIndex).get(current.index+1);
                pq.offer(new Element(value,current.listIndex,current.index+1));
                max = Math.max(value,max);
            }
        }
        return  new int[]{start,end};
    }
}
