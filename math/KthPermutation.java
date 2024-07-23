package math;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++)
            fact[i] = fact[i-1]*i;
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--){
            int index = k/fact[i-1];
            sb.append(list.get(index));
            list.remove(index);
            k%= fact[i-1];
        }
        return sb.toString();
    }
}
