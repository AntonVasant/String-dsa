package string;

public class DecimalToBinary {
    public String decimalToBinary(int number){
        StringBuilder sb = new StringBuilder();
        while(number>0){
            int remainder=number%2;
            sb.insert(0,remainder);
            number/=2;
        }
        return sb.toString();
    }
}
