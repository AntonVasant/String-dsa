package string;

public class VowelsSubString {
    public int maxVowels(String s, int k) {
        int len = s.length();
        int max = 0;
        int count =0;
        for(int i = 0;i < len; i++){
            if(i < k){
                if(isVowel(s.charAt(i)))
                    count++;
            }else{
                if(isVowel(s.charAt(i)))
                    count++;
                if(isVowel(s.charAt(i-k)))
                    count--;
            }
            if(i >= k-1)
                max = Math.max(max,count);
        }
        return max;
    }

    private boolean isVowel(char c){
        return "aeiou".indexOf(c) != -1;
    }
}
