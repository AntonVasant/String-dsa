package gfg;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t){
        int[] one = new int[256];
        int[] two = new int[256];
        int n = s.length();
        if (n != t.length()) return false;
        for (int i = 0; i < n; i++){
            char first = s.charAt(i);
            char second  = t.charAt(i);
            if (one[second] == 0 && two[first] == 0){
                one[second] = second;
                two[first] = first;
            }
            else if (one[second] != second  || two[first] != first) return false;
        }
        return true;
    }


    static String largestNumber(int n, int sum)
    {
        if (sum > 9*n) return "-1";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            int ans = Math.max(9,sum);
            sb.append(ans);
            sum -= ans;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(5,12));
    }
}
