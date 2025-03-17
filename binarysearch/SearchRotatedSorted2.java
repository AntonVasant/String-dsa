package binarysearch;

import java.util.*;

public class SearchRotatedSorted2 {
    public boolean search(int[]  arr, int target) {
        int low = 0;
        int high =  arr.length-1;
        int mid;
        while(low <= high){
            mid = (low + high)/2;
            if(arr[mid] == target) return true;
            if(arr[mid] ==  arr[low] &&  arr[mid] ==  arr[high]){
                low = low + 1;
                high = high - 1;
                continue;
            }
            if(arr[low] <=  arr[mid]){
                if(target >=  arr[low] && target <=  arr[mid]){
                    high = mid - 1;
                }else low = mid + 1;
            }
            if(arr[high] >=  arr[mid]){
                if(target >=  arr[mid] && target <=  arr[high]){
                    low = mid + 1;
                }else high = mid - 1;
            }
        }
        return false;
    }

    public static boolean isRotated(String s1, String s2) {
        char[] first = rotate(s1.toCharArray());
        System.out.println(Arrays.toString(first));
        String ans = new String(rotate(first));
        System.out.println(ans);
        return ans.equals(s2);
    }


    private static char[] rotate(char[] arr){
        for (int i = 1; i < arr.length; i++){
            char temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }


    String rremove(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n){
            if (i < n-1 && s.charAt(i) == s.charAt(i+1)){
                while (i < n - 1 && s.charAt(i) == s.charAt(i+1))
                    i++;
            }
            else sb.append(s.charAt(i));
            i++;
        }
        String str = sb.toString();
        if (str.equals(s))
            return s;
        return rremove(str);
    }

    String removeDups(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            int j;
            for (j = 0; j < n; j++){
                if (s.charAt(i) == s.charAt(j))
                    break;
            }
            if (i == j)
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public int longestSubstrDistinctChars(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int ans= 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= left){
                left = map.get(c)+1;
            }
            map.put(c,i);
            ans = Math.max(ans, i - left+1);
        }
        return ans;
    }




    boolean sameFreq(String s) {
        HashMap<Character, Integer> characterCountMap = new HashMap<>();
        HashMap<Integer, Integer> frequencyCount = new HashMap<>();
        for (char c : s.toCharArray())
            characterCountMap.put(c, characterCountMap.getOrDefault(c,0) +1);
        for (int values : characterCountMap.values())
            frequencyCount.put(values, frequencyCount.getOrDefault(values, 0) + 1);
        if (frequencyCount.size() == 1) return true;
        else if (frequencyCount.size() == 2) {
            int[] freq = new int[2];
            int index = 0;
            for (int value : frequencyCount.values()){
                freq[index++] = value;
            }
            if (frequencyCount.get(freq[0]) == 1 && freq[0] == 1)
                return true;
            return freq[1] == freq[0] + 1 && frequencyCount.get(freq[1]) == 1;
        }
        return false;
    }

    static int countMin(String str){
        String reverse = new StringBuilder(str).reverse().toString();
        return str.length() - helper(str,reverse);
    }


    private static int helper(String s1, String s2){
        int n = s1.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n][n];
    }









    public static void main(String[] args) {
        SearchRotatedSorted2 sorted2 = new SearchRotatedSorted2();
    }
}
