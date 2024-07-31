package math;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumber {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++){
            if (helper(i)){
                list.add(i);
            }
        }
        return list;
    }

    private boolean helper(int num){
        String cur = String.valueOf(num);
        for (int i = 0; i < cur.length(); i++){
            int n = Integer.parseInt(String.valueOf(cur.charAt(i)));
            if (num % n != 0) return  false;
        }
        return true;
    }
}
