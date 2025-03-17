package LLD;

public class SimpleCipher {


    public static void main(String[] a){
        String s = "8124869726";
        for (char c : s.toCharArray()) {
            System.out.print(getChat(c,1));
        }
    }

    private static char shiftChar(char c, int shift) {
        if (Character.isLowerCase(c)) {
            return (char) ('a' + (c - 'a' + shift + 26) % 26); // Wrap around for lowercase
        } else if (Character.isUpperCase(c)) {
            return (char) ('A' + (c - 'A' + shift + 26) % 26); // Wrap around for uppercase
        } else if (Character.isDigit(c)) {
            return (char) ('0' + (c - '0' + shift + 10) % 10); // Wrap around for digits
        } else {
            return c; // Keep special characters unchanged
        }
    }

    private static char getChat(char c, int shift) {
        if (Character.isDigit(c))
            return (char) ('0' + ( c- '0' + shift + 10) % 10);
        else if (Character.isLowerCase(c))
            return (char) ('a' + (c-'a' + shift + 26) % 26);
        else return (char) ('A' + (c-'A' + shift + 26) % 26);
    }
}
