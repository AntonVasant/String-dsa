package greedy;

public class StringPasswordCheck {
    public int strongPasswordChecker(String password) {
        int len = password.length();
        int i = 0;
        boolean isUpper = false;
        boolean isLower = false;
        boolean isDigit = false;
        for (char c : password.toCharArray()){
            if (Character.isLowerCase(c)) isLower = true;
            else if (Character.isUpperCase(c)) isUpper = true;
            else if (Character.isDigit(c)) isDigit = true;
        }
        int[] count = new int[3];
        while (i < len){
            int j = i;
            while (j < len && password.charAt(i) == password.charAt(j))
                j++;
            int length = j - i;
            if (length >= 3){
                count[length%3]++;
            }
            i = j;
        }
        int replace = count[0] + 2 * count[1] + 3 * count[2];
        int needed = (isDigit ? 0 : 1) + (isLower ? 0 : 1) + (isUpper ? 0 : 1);
        if (len <= 6){
            return Math.max(needed,6-len);
        } else if (len <= 20) {
            return Math.max(needed,replace);
        }
        else {
            int excess = len - 20;
            replace = Math.max(replace -excess,0);
            return excess + Math.max(needed,replace);
        }
    }
}
