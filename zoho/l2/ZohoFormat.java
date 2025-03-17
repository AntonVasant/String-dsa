package zoho.l2;

import java.util.*;
public class ZohoFormat {
    public static ArrayList<Integer> topKFrequent(int[] arr, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : arr){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        int[] freq = new int[max - min +1];
        for (int n : arr)
            freq[n - min]++;


        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++){
            int times = -1;
            int maxNumber = -1;
            for (int j = 0; j < max - min+1; j++){
                if (freq[j] > times || freq[j] == times && j + min > maxNumber){
                    maxNumber = j + min;
                    times = freq[j];
                }
            }

            freq[maxNumber - min] = 0;
            list.add(maxNumber);
        }
        return list;
    }
    public int maxLen(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i] == 1 ? 1 : -1;
            if (sum == 0)
                maxLength = i+1;
            else if (map.containsKey(sum))
                maxLength = Math.max(maxLength, i - map.get(sum));

            else map.put(sum, i);
        }
        return maxLength;
    }

    private static void countFreq(int[] arr, int[] freq){
        for (int j : arr) {
            freq[j]++;
        }
    }
    public int minIncrements(int[] arr) {
        Arrays.sort(arr);
        int number = 0;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] <= arr[i-1]){
                number += (arr[i-1] - arr[i]+1);
                arr[i] = arr[i-1]+1;
            }
        }
        return number;
    }
    public static String  fractionToDecimal(int numerator, int denominator){
        StringBuilder result = new StringBuilder();
        if (numerator == 0)
            return "0";
        if ((numerator < 0 ) ^ (denominator < 0))
            result.append("-");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        long remainder = num % den;
        result.append(num/den);
        if (remainder == 0)
            return result.toString();
        result.append(".");
        HashMap<Long, Integer> remainderMap = new HashMap<>();
        while (remainder != 0){
            if (remainderMap.containsKey(remainder)){
                int index = remainderMap.get(remainder);
                result.insert(index,"(");
                result.append(")");
                return result.toString();
            }
            remainderMap.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder/den);
            remainder %= den;
        }
        return result.toString();
    }
    int transform (String A, String B){
        Map<Character, Integer> map = new HashMap<>();
        int n = A.length();
        int m = B.length();
        if (m != n)
            return -1;
        for (char c : A.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        for (char c : B.toCharArray()){
            if (map.containsKey(c))
                map.put(c, map.getOrDefault(c,0)-1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() != 0)
                return -1;
        }
        int res = 0;
        int i = n-1;
        int j = n -1;
        while (i >= 0 && j >= 0){
            while (i >= 0 && A.charAt(i) != B.charAt(j)){
                i--;
                res++;
            }
            i--;
            j--;
        }
        return res;
    }
    static int leastInterval(int N, int K, char[] tasks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        Queue<int[]> queue = new LinkedList<>();
        int[] freq = new int[26];
        for (char c : tasks)
            freq[c - 'A']++;
        for (int n : freq){
            if (n > 0)
                pq.offer(n);
        }
        int time = 0;
        while (!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if (!pq.isEmpty()){
                int current = pq.poll()-1;
                if (current > 0)
                    queue.offer(new int[]{current, time+K});
            }

            if (!queue.isEmpty() && queue.peek()[1] >= time){
                pq.offer(queue.poll()[0]);
            }
        }
        return time;
    }
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1,3));
    }

}
