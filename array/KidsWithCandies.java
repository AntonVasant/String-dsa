package array;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> booleanList  = new ArrayList<>();
        int max = 0;
        for (int num : candies){
            if (num > max)
                max = num;
        }
        for (int i = 0; i < candies.length; i++){
            if (candies[i] + extraCandies >= max)
                booleanList.add(true);
            else booleanList.add(false);
        }
        return booleanList;
    }
}
