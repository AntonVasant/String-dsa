package array;

public class NPrimeNumbers {
    public int[] prime(int number){
        int result[] = new int[number];
        int count=0;
        int num=2;
        while(count<number){
            if(isPrime(num))
                result[count++]=num;
            num++;
        }
        return result;
    }
    private boolean isPrime(int number){
        if(number<2)
            return false;
        for(int i=2; i <= Math.sqrt(number); i++){
            if(number%i==0)
                return false;
        }
        return true;
    }
}
