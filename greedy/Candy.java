package greedy;

import java.util.*;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] right = new int[n];
        int[] left = new int[n];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < n; i++){
            right[i] = ratings[i] > ratings[i-1] ? right[i-1]+1 : 1;
        }
        for (int i = n-2; i >=0; i--){
            left[i] = ratings[i] > ratings[i+1] ? left[i+1]+1 : 1;
        }
        int total = 0;
        for (int i =0; i < n; i++){
            total += Math.max(right[i] ,left[i]);
        }
        return total;
    }

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a,b) -> a[0] == b[0] ? Integer.compare(b[1] , a[1]) : Integer.compare(a[0], b[0]));
        int count = 0;
        int n = properties.length;
        int max = properties[n-1][1];
        for (int i = n - 2; i >= 0; i--){
            if (max > properties[i][1])
                count++;
            else max = properties[i][1];
        }
        
        return count;
    }



    public int findMinFibonacciNumbers(int k) {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(1L);
        long sum = list.get(list.size() -1) + list.get(list.size()- 2);
        while (sum <= k){
            list.add(sum);
            sum = list.get(list.size() -1) + list.get(list.size()- 2);
        }
        int ans = 0;
        int j  = list.size() -1;
        while (k > 0){
            ans += (int) (k/ list.get(j));
            k %= list.get(j);
            j--;
        }
        return ans;
    }


    public static boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();
        int[] arr = new int[26], brr = new int[26];
        for(int i = 0; i < n; i++) arr[s1.charAt(i) - 'a']++;
        for(int i = 0; i < n; i++) brr[s2.charAt(i) - 'a']++;
        int count1 = 0, count2 = 0;
        boolean f1 = false, f2 = false;
        for(int i = 0; i < 26; i++) {
            count1 += arr[i];
            count2 += brr[i];
            if(count1 > count2) {
                if(f2) return false;
                f1 = true;
            } else if(count2 > count1) {
                if(f1) return false;
                f2 = true;
            }
        }
        return true;
    }







    public static int findComplement(int num) {
        if (num == 0) return 1;

        int bitLength = Integer.toBinaryString(num).length();

        int mask = (1 << bitLength) - 1;
        System.out.println(Integer.toBinaryString(mask));

        return num ^ mask;
    }


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(133));
        int i = findComplement(14);
        System.out.println(i +"  "+ Integer.toBinaryString(i));
    }
}
