package stack;

public class DecodeStringReturnChar {
    public String decodeAtIndex(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()){
            if (Character.isDigit(c)){
                num = num * 10 + c -'0';
                if (sb.length() > k){
                    System.out.println(sb);
                    return String.valueOf(sb.charAt(k-1));
                }
            }
            else {
                if (num > 0){
                    StringBuilder cur = sb;
                    sb.append(cur.toString().repeat(num-1));
                    num = 0;
                }
                sb.append(c);
            }
        }
        return String.valueOf(s.charAt(k-1));
    }
}
