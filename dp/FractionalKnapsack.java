package dp;

import java.util.Arrays;
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
    double fractionalKnapsack(int w, Item[] arr, int n) {
        Arrays.sort(arr, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
       return helper(new HashMap<>(),w,arr,0);
    }


    private double helper(Map<String,Double> memo, int w,Item[] arr,int index){
        if (index == arr.length || w == 0) return 0;
        String key = index+ ","+w;
        if (memo.containsKey(key))
            return memo.get(key);
        double take = 0;
        if (w < arr[index].weight){
            take = ((double) arr[index].value/arr[index].weight)*w;
        }
        else take = (double) arr[index].value + helper(memo,w-arr[index].weight,arr,index+1);
        double nonTake = helper(memo,w,arr,index+1);
        double ans = Math.max(take,nonTake);
        memo.put(key,ans);
        return ans;
    }
}
