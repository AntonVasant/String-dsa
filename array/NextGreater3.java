package array;

public class NextGreater3 {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int i = arr.length-2;
        while (i >= 0 && arr[i] >= arr[i+1])
            i--;
        if (i == -1) return -1;
        int j = arr.length-1;
        while (j > i && arr[j] <= arr[i])
            j--;
        swap(arr,i,j);
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k <= i; k++){
            sb.append(arr[k]);
        }
        for (int k = arr.length-1; k >i; k--){
            sb.append(arr[k]);
        }
        long ans = Long.parseLong(sb.toString());
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    private void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
