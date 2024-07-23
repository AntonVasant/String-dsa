package string;

public class MagicalString {
    public int magicalString(int n) {
        int[] arr =  new int[n+1];
        arr[0] =1;
        arr[1] = 2;
        arr[2] = 2;
        int head = 2;
        int tails = 3;
        int count = 1;
        int num = 1;
        while (tails < n){
            for (int i  = 0; i < arr[head] && tails < n; i++){
                arr[tails] = num;
                if (num == 1) count++;
                tails++;
            }
            num = num == 2 ? 1 : 2;
            head++;
        }
        return count;
    }
}
