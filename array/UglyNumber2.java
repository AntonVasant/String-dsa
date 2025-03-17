package array;

import java.util.ArrayList;

public class UglyNumber2 {

    public static int nthUglyNumber(int n) {
        int[] arr = new int[n];
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int next2 = 2;
        int next3 = 3;
        int next5 = 5;
        arr[0] = 1;
        for (int i = 1; i < n; i++){
            int next = Math.min(next2, Math.min(next3, next5));
            arr[i] = next;
            if (next == next2){
                i2++;
                next2 = arr[i2] * 2;
            }
            if (next == next3){
                i3++;
                next3 = arr[i3] * 3;
            }
            if (next == next5){
                i5++;
                next5 = arr[i5] * 5;
            }
        }
        return arr[n-1];
    }

    public static ArrayList<Integer> printClosest(int[] arr, int[] brr, int n, int m, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = m-1;
        int closeSum = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;
        while (left < n && right >= 0){
            int sum = arr[left] + brr[right];
            if (Math.abs(x - sum) < Math.abs(x - closeSum)){
                closeSum = sum;
                num1 = arr[left];
                num2 = brr[right];
            }
            if (sum < x)
                left++;
            else right--;
        }
         list.add(num1);
        list.add(num2);
        return list;
    }

    static String[] keyPad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static ArrayList <String> possibleWords(int a[], int N){
        ArrayList<String> list = new ArrayList<>();
        helper(list,new StringBuilder(),0,a);
        return list;
    }

    private static void helper(ArrayList<String> list, StringBuilder s, int index, int[] arr){
        if (index == arr.length){
            list.add(s.toString());
            return;
        }

        String current = keyPad[arr[index]];
        for (char c : current.toCharArray()){
            s.append(c);
            helper(list,s,index+1,arr);
            s.deleteCharAt(s.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(possibleWords(new int[]{2,3,4},3));
    }
}
