package bitwise;

public class Shift {
    public static void helper(){
        int n = 9;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        n = (n >> 2);
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
    }
}
