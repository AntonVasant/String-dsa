package string;

public class IntegerToWords {
        private final String[] lessThan20 = {
                "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };

        private final String[] tens = {
                "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };

        private final String[] thousands = {
                "", "Thousand", "Million", "Billion"
        };

        public String numberToWords(int num) {
            if (num == 0) return "Zero";
            return helper(num).trim();
        }

        private String helper(int num) {
            if (num == 0) return "";
            if (num < 20) return lessThan20[num] + " ";
            if (num < 100) return tens[num / 10] + " " + helper(num % 10);
            if (num < 1000) return lessThan20[num / 100] + " Hundred " + helper(num % 100);

            for (int i = 0; i < thousands.length; i++) {
                int divisor = (int) Math.pow(1000, thousands.length - i - 1);
                if (num >= divisor) {
                    return helper(num / divisor) + thousands[i] + " " + helper(num % divisor);
                }
            }

            return "";
        }
    }
