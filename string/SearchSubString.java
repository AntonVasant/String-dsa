package string;

public class SearchSubString {
    public int search(String text,String pattern){
        int t=text.length();
        int p = pattern.length();
        for(int i=0;i<=t-p;i++){
            int j;
            for (j=0;j<p;j++){
                if(text.charAt(i+j)!=pattern.charAt(j))
                    break;
            }
            if(j==p)
              return i;
        }
        return -1;
    }
}
