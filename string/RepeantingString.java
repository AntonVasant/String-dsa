package string;

public class RepeantingString {
    public int repeatedStringMatch(String a, String b) {
        if (a == null || b == null || b.isEmpty() || a.isEmpty())
            return -1;
        int n = (int)Math.ceil((double)b.length()/a.length());
        StringBuilder str = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++){
            str.append(a);
            count++;
        }
        String s = str.toString();
        if (s.contains(b)) return count;
        if (s.concat(a).contains(b))
            return count+1;
        return -1;
    }
}
