package dp;

import java.util.*;

public class WordBreak2 {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Map<String,List<String>> memo = new HashMap<>();
        return helper(memo,s,wordDict);
    }

    private static List<String> helper(Map<String,List<String>> memo,String s,List<String> words){
        if (memo.containsKey(s))
            return memo.get(s);
        List<String> list = new ArrayList<>();
        if (s.isEmpty()){
            list.add("");
            return list;
        }

        for (String str : words){
            if (s.startsWith(str)){
                String rem = s.substring(str.length());
                List<String> res = helper(memo,rem,words);
                for (String st : res){
                    String space = st.isEmpty() ? "" : " ";
                    list.add(str+space+st);
                }
            }
        }
        memo.put(s,list);
        return list;
    }

    public static void main(String[] args) {
        numberOfSubstrings("abcabc");
    }

    //return the number of sub strings that contain the letters abc
    public static int numberOfSubstrings(String s) {
        int[] hash = new int[3];
        Arrays.fill(hash,-1);
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            hash[s.charAt(i) - 'a'] = i;
            if (hash[0] != -1 && hash[1] != -1 && hash[2] != -1){
                ans += 1 + Math.min(hash[0] ,Math.min(hash[1],hash[2]));
            }
        }
        return ans;
    }


    /*
    You are given n points in the plane that are all distinct, where points[i] = [xi, yi]. A boomerang is a tuple of points
    (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
Return the number of boomerangs.
Input: points = [[0,0],[1,0],[2,0]]
Output: 2
Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
     */
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            map.clear();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int distance = getDifference(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (int values : map.values()){
                ans += values * (values -1);
            }
        }
        return ans;
    }

    private int getDifference(int[] point1, int[] point2) {
        int dx = point1[0] - point2[0];
        int dy = point1[1] - point2[1];
        return dx * dx + dy * dy;
    }

}
