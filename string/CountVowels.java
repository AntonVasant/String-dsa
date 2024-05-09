package string;

public class CountVowels {
    public int vowels(String str)
    {
        int count=0;
        String s = str.toLowerCase();
        for(char c : s.toCharArray()){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
                count++;
        }
        return count;
    }
}
