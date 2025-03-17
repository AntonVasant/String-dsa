package math;

public class AddictiveNumber {
        public boolean isAdditiveNumber(String num) {
            return backtrack(num, 0, -1, -1, -1);
        }

        private boolean backtrack(String num, int index, long num1, long num2, int count) {
            int n = num.length();
            if (index == n)
                return count >= 3;

            long currentNum = 0;
            for (int i = index; i < n; i++){
                if (i > index && num.charAt(index) == '0')
                    break;

                currentNum = currentNum * 10 + (num.charAt(i) - '0');
                if (count >= 2) {
                    long sum = num1 + num2;
                    if (currentNum > sum)
                        break;

                    if (currentNum < sum)
                        continue;

                }
                if (backtrack(num, i + 1, num2, currentNum, count + 1))
                    return true;

            }
            return false;
        }
    }