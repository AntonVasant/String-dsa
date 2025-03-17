package string;
public class NumberToWords {
    private static final String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static void main(String[] args) {
        long number = 1000;
        String result = convertNumberToWords(number);
        System.out.println(result);
    }

    public static String convertNumberToWords(long number) {
        if (number == 0) {
            return "zero";
        }

        String words = "";

        if (number >= 10000000){
            words += convertThreeDigitGroup((int) (number / 10000000)) + " crore ";
            number %= 10000000;
        }

        if (number >= 100000){
            words += convertThreeDigitGroup((int) (number / 100000)) + " lakh ";
            number %= 100000;
        }


        if (number >= 1000){
            words += convertThreeDigitGroup((int) (number / 1000)) + " thousand ";
            number %= 1000;
        }


        words += convertThreeDigitGroup((int) number);

        return words.trim();
    }

    private static String convertThreeDigitGroup(int number) {
        String result = "";

        if (number >= 100) {
            result += units[number / 100] + " hundred ";
            number %= 100;
        }

        if (number >= 20) {
            result += tens[number / 10] + " ";
            number %= 10;
        }

        if (number > 0) {
            result += units[number] + " ";
        }

        return result;
    }
}
