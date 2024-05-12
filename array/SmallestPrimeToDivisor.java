package array;

public class SmallestPrimeToDivisor {
    public int[] prime(int[] first,int[] second){
        int prime=0;
        int num=0;
        int[] res = new int[first.length];
       for(int i=0;i< first.length;i++){
           num=first[i];
           if(first[i]%second[i]==0){
               res[i]=0;
               continue;
           }
           while(true){
               if(isPrime(prime)){
                   if(num%second[i]==0) {
                       res[i] = prime;
                       break;
                   }
               }
               prime++;
               num++;
           }
           prime=0;
       }
        return res;
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
