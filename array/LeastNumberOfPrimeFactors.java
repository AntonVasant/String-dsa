package array;

import java.util.*;

public class LeastNumberOfPrimeFactors {
    public int[] primeFactors(int[] array){
        int[] result = new int[array.length];
        Map<Integer,Integer> map = new HashMap<>();
        int temp=0;
        for(int num : array){
            temp=primeNumbers(num);
            map.put(num,temp);
        }
        List<Map.Entry<Integer,Integer>>list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        int index=0;
        for(Map.Entry<Integer,Integer> entry : list){
            int key = entry.getKey();
            result[index++]=key;
        }
        return result;
    }
    private int primeNumbers(int number){
        int count=0;
        for (int i=2;i<Math.sqrt(number);i++){
            if(number%i==0 && isPrime(i))
                count++;
        }
        return count;
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
