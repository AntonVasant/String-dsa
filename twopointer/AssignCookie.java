package twopointer;

public class AssignCookie {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < g.length && j < s.length){
            if (g[i] <= s[j]){
                i++;
                count++;
            }
            j++;
        }
        return count;
    }
}
