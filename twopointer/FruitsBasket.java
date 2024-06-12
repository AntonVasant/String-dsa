package twopointer;

import java.util.HashMap;
import java.util.Map;

public class FruitsBasket {
    public int totalFruit(int[] fruits) {
        int max = 0;
        int left = 0;
        int right = 0;
        int n = fruits.length;
        Map<Integer,Integer> map = new HashMap<>();
        while(right < n){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size() > 2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left]) == 0)
                    map.remove(fruits[left]);
                left++;
            }
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}
