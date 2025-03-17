package greedy;

public class GreaterNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++){
            arr[i] = String.valueOf(nums[i]);
        }

        sort(arr);
        if (arr[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String d : arr)
            sb.append(d);
        return sb.toString();
    }


    private void sort(String[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-1; j++){
                if (!helper(arr[j],arr[j+1])){
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    private boolean helper(String a,String b){
        return (a+b).compareTo(b+a) > 0;
    }
}
