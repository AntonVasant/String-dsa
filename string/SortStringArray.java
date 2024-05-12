package string;

public class SortStringArray {
    public String[] sort(String[] str){
        for (int i=0;i<str.length-1;i++){
            for (int j=1;j<str.length;j++){
                if(str[i].compareTo(str[j])>0){
                    String temp = str[i];
                    str[i]=str[j];
                    str[j]=temp;
                }
            }
        }
        return str;
    }
}
