package greedy;

public class MinimumSwapToPalindrome {
    public int minMovesToMakePalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        int moves = 0;
        char[] arr = s.toCharArray();
        while (left < right){
            if (arr[left] == arr[right]){
                left++;
                right--;
            }
            else {
                int k = right;
                while (k > left && arr[k] != arr[left])
                    k--;
                if (k == left){
                    swap(arr,k,k+1);
                    moves++;
                }
                else {
                    for (int i = k; i < right; i++){
                        swap(arr,i,i+1);
                        moves++;
                    }
                }
            }
        }
        return moves;
    }

    private void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
