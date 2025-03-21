package rescursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<>(),1,n,k);
        return ans;
    }


    private static void helper(List<List<Integer>> ans,List<Integer> res,int index, int n,int k){
        if(res.size() == k){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int start = index; start <= n; start++){
            res.add(start);
            helper(ans,res,start+1,n,k);
            res.remove(res.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(7,3));
    }
}
