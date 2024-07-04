package rescursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommomSubArray {
    public static int findLength(int[] nums1, int[] nums2) {
        Map<String,Integer> map = new HashMap<>();
        return helper(nums1,nums2,0,0,0,map);
    }


    private static int helper(int[] array1,int[] array2,int index1,int index2,int count, Map<String,Integer> dp){
        if (index1 == array1.length || index2 == array2.length) return count;
        String key = index1+","+index2+","+count;
        if (dp.containsKey(key)) return dp.get(key);

        int take = count;
        if(array1[index1] == array2[index2]){
            take = helper(array1,array2,index1+1,index2+1,count+1,dp);
        }
        int first = helper(array1,array2,index1+1,index2,0,dp);
        int sec = helper(array1,array2,index1,index2+1,0,dp);
        int len = Math.max(take,Math.max(first,sec));
        dp.put(key,len);
        return len;
    }
}
