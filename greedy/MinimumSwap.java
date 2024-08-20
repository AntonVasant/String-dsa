package greedy;

public class MinimumSwap {
    public int maximumSwap(int num) {
        int[] last = new int[10];
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; i++)
            last[arr[i] - '0'] = i;
        for (int i = 0; i < arr.length; i++){
            for (int j = 9; j > arr[i] - '0'; j--){
                if (last[j] > i){
                    char temp = arr[i];
                    arr[i] = arr[last[j]];
                    arr[last[j]] = temp;
                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return num;
    }
}
