package dp;

import java.util.HashMap;
import java.util.Map;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
public class FractionalKnapsack {
    double fractionalKnapsack(int w, Item arr[], int n) {
       return helper(new HashMap<>(),w,arr,0);
    }


    private double helper(Map<String,Double> map,int w, Item[] arr, int index){
        if (index == arr.length) return 0;
        String s = index+","+w;
        if (map.containsKey(s))
            return map.get(s);
        double take = 0;
        if (w < arr[index].weight){
            take = (double) (arr[index].value/arr[index].weight)*w + helper(map, 0, arr, index+1);
        }else take = arr[index].value + helper(map, w-arr[index].weight, arr, index+1);
        double non = helper(map, w, arr, index+1);
        double max = Math.max(take,non);
        map.put(s,max);
        return max;
    }
}
