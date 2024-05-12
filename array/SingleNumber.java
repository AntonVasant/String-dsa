package array;

public class SingleNumber {
    public int single(int array[]){
        int result=0;
        for(int num: array)
            result^=num;
        return result;
    }
}
