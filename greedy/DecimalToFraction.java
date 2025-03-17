package greedy;

public class DecimalToFraction {
    public static void decimalFraction(double number){
        String dec = Double.toString(number);
        int index = dec.indexOf(".");
        int balance = dec.length() - index - 1;
        int denominator = (int) Math.pow(10,balance);
        int numerator = (int) (number * denominator);
        System.out.println(denominator+" "+numerator);
        int gcd = GCD(denominator,numerator);
        denominator /= gcd;
        numerator /= gcd;
        System.out.println(numerator +"/"+ denominator);
    }


    private static int GCD(int num1,int num2){
        int n = Math.min(num1,num2);
        for (int i = n; i > 0; i--){
            if (num1%i == 0 && num2%i == 0)
                return i;
        }
        return -1;
    }

    public static void main(String[] a){
        decimalFraction(3.125);
    }
}
