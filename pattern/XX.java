package pattern;

public class XX {
    public static void print(String s){
        for (int i = 0; i < s.length();i++){
            for (int j = 0; j < s.length(); j++){
                if (i == j || i+j == s.length()-1)
                    System.out.print(s.charAt(j)+" ");
                 else if (j == s.length()/2) {
                    System.out.print(s.charAt(i)+" ");
                } else if (i == s.length()/2) {
                    System.out.print(s.charAt(j));
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void printX(String word){
        int n = word.length();
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                System.out.print(i == j || j == ((n+1)-i) ? word.charAt(i-1) : " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        printX("Mershesha");
    }
}
