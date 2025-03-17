package array;

public class GreaterNumber {
    public static void greater(int[] array,int S){
        int remaining = S;
        StringBuilder stringBuilder = new StringBuilder();
        for (int j : array)
            while (remaining >= j) {
                int digit = countDigit(j);
                stringBuilder.append(j);
                remaining -= digit;
            }
        System.out.println(stringBuilder);
    }

    private static int countDigit(int number){
        int ans = 0;
        while (number > 0){
            int bal = number % 10;
            ans += bal;
            number /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        greater(new int[]{43,27,51,3,5,6,4,3},5);

    }
}
