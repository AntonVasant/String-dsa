package greedy;

public class StringAbBa {
    public int maximumGain(String s, int x, int y) {
        if (x > y)
            return helper(s,"ab","ba",x,y);
        else return helper(s,"ba","ab",y,x);
    }

    private int helper(String s,String first,String sec,int point1,int point2){
        StringBuilder sb = new StringBuilder();
        int ans  =0;
        for (char c : s.toCharArray()){
            sb.append(c);
            if (sb.length() >= 2 && sb.substring(sb.length()-2).equals(first)){
                sb.setLength(sb.length()-2);
                ans += point1;
            }
        }
        s = sb.toString();
        sb = new StringBuilder();
        for (char c : s.toCharArray()){
            sb.append(c);
            if (sb.length() >= 2 && sb.substring(sb.length()-2).equals(sec)){
                ans += point2;
                sb.setLength(sb.length()-2);
            }
        }
        return ans;
    }
}
