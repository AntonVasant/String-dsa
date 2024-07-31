package math;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);
        for (int i = 1; i < numRows; i++){
            List<Integer> prev = ans.get(i-1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j < i; j++){
                cur.add(prev.get(j-1) + prev.get(j));
            }
            cur.add(1);
            ans.add(cur);
        }
        return ans;
    }
}
