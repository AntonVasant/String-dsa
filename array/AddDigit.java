package array;

public class AddDigit {
    public int addDigit(int number,int digit){
        int multiplier=1;
        int result=0;
        while(number>0){
            int currentDigit = number%10;
            int numberAdd = currentDigit+digit;
            result+=numberAdd*multiplier;
            multiplier*=10;
            number/=10;
        }
        return result;
    }
}
