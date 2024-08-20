package string;

import java.util.LinkedList;
import java.util.List;

public class ShortestDistanceForLetter {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] arr = new int[n];
        List<Integer> list = new LinkedList<>();
        for(int i =  0; i< n; i++){
            if (s.charAt(i) == c) list.add(i);
        }
        int index  = 0;
        int size = list.size();
        for (int i = 0; i < n; i++){
            if (index < size && i == list.get(index)){
                arr[i] = 0;
                index++;
            }
            else if (index > 0 && index < size){
                arr[i] = Math.min(Math.abs(list.get(index) - i),Math.abs(i - list.get(index-1)));
            }
            else if (index == size) arr[i] = Math.abs(list.get(size-1) - i);
            else arr[i] = Math.abs(list.get(0) - i);
        }
        return arr;
    }
}
