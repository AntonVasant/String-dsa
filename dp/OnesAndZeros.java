package dp;

public class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int count = 0;
        for (int i = 0; i < strs.length; i++){
            if (helper(strs[i],m,n)) count++;
        }
        return count;
    }

    private boolean helper(String s ,int m,int n){
        int one = 0;
        int zero = 0;
        for (char c : s.toCharArray()){
            if (c == '0') zero++;
            else one++;
            if (one > n || zero > m) return false;
        }
        return true;
    }
}
