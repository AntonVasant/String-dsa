package math;

public class NumberOfDigitOnes {

    public static int countDigitOne(int n) {
        int ones_count = 0;
        int factor = 1;

        while (factor <= n) {
            int left_part = n / (factor * 10);
            int current_digit = (n / factor) % 10;
            int right_part = n % factor;

            ones_count += left_part * factor;

            if (current_digit == 1)
                ones_count += right_part + 1;
            else if (current_digit > 1)
                ones_count += factor;

            factor *= 10;  // Move to the next digit position
        }

        return ones_count;
    }



    public static void main(String[] args) {

    }

}
