package array;

public class GreaterNumber {
    public static void greater(int[] array,int S){
        int remaining = S;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++){
            while (remaining >= array[i]){
                int digit = countDigit(array[i]);
                stringBuilder.append(array[i]);
                remaining -= digit;
            }
        }
        System.out.println(stringBuilder);
    }

    private static int countDigit(int number){
        int ans = 0;
        while (number > 0){
            int bal = number%10;
            ans += bal;
            number/= 10;
        }
        return ans;
    }
}
