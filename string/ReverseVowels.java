package string;

public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int pointer1 = 0;
        int pointer2 = s.length() - 1;

        while (pointer1 < pointer2) {
            if (!isVowel(chars[pointer1])) {
                pointer1++;
                continue;
            }

            if (!isVowel(chars[pointer2])) {
                pointer2--;
                continue;
            }
            char temp = chars[pointer1];
            chars[pointer1] = chars[pointer2];
            chars[pointer2] = temp;

            pointer1++;
            pointer2--;
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
