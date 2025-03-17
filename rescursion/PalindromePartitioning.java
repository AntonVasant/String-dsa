package rescursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void partitioning(String str,int index,List<List<String>> lists,List<String> list){
        if(index == str.length()){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<str.length();i++){
            if (isPalindrome(str,index,i)){
                list.add(str.substring(index,i+1));
                partitioning(str,i+1,lists,list);
                list.remove(list.size()-1);
            }
        }

    }
    private static boolean isPalindrome(String str,int start,int end){
        while(start<=end){
            if(str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        partitioning("malayalam", 0,lists, new ArrayList<>());
        System.out.println(lists);
    }
}
