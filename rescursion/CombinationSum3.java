package rescursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),n,k,1);
        return res;
    }

    private void helper(List<List<Integer>> res,List<Integer> temp,int sum,int size,int index){
        if (sum == 0 && temp.size() == size){
            res.add(new ArrayList<>(temp));
        }else if (sum > 0 && temp.size() < size){
            for (int i = index; i <= 9; i++){
                temp.add(i);
                helper(res, temp, sum-i, size, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
