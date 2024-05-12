package array;

public class TwistedPrimeNumber {
    public boolean twistedPrime(int number){
        String str = String.valueOf(number);
        while(!str.isEmpty()){
            if(!isPrime(Integer.parseInt(str)))
                return false;
            str = str.substring(1);
        }
        return true;
    }
    private boolean isPrime(int number){
        if(number<2)
            return false;
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0)
                return false;
        }
        return true;
    }
}
