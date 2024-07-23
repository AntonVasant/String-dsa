package string;

public class ReverseAllWords {
    public String reverseWords(String s) {
       int i = 0;
       int j = 0;
       StringBuilder ans = new StringBuilder();
       while (i < s.length()){
           while (s.charAt(i) != ' ' ||  i == s.length()){
               i++;
           }
           ans.append(reverse(s.substring(j,i)));
           ans.append(" ");
           i++;
           j = i;

       }
       return ans.toString().trim();
    }

    private String reverse(String s){
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length-1;
        while (i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}
