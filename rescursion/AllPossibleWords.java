package rescursion;

import java.util.*;

public class AllPossibleWords {


    /*
    A subset of nums is beautiful if it does not contain two integers with an absolute difference equal to k.
     */
    public static int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return helper(nums, 0, new HashMap<>(), k) - 1;
    }

    private static int helper(int[] arr, int index, Map<Integer, Integer> map, int k){
        if (index == arr.length)
            return 1;
        int count = helper(arr, index+1, map, k);
        int num = arr[index];
        if (!map.containsKey(num - k) && !map.containsKey(num+k)){
            map.put(num, map.getOrDefault(num, 0) +1);
            count += helper(arr, index+1, map, k);
            map.put(num, map.getOrDefault(num, 0)-1);
            if (map.get(num) == 0)
                map.remove(num);
        }
        return count;
    }




    public static List<String> findWords(String number){
        List<String> list = new ArrayList<>();
        wordFinder(number, 0 ,list, new StringBuilder());
        return list;
    }

   private static void wordFinder(String number, int index, List<String> list, StringBuilder builder){
        if (index >= number.length()){
            list.add(builder.toString());
            return;
        }

        for (int i = index; i < number.length() && i <= index + 2; i++){
            int sub = Integer.parseInt(number.substring(index, i + 1));
            if (sub > 0 && sub < 27){

                builder.append((char) ('A' + (sub - 1)));
                wordFinder(number, i + 1, list, builder);
                builder.deleteCharAt(builder.length()-1);
            }
        }
   }

    public static void main(String[] args) {
        System.out.println(findWords("123123"));
    }


}
