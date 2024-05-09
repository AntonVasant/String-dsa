package string;

public class NumberOfWordsInString {
    public void numberOfString(String str){
        String[] array = str.split("//s");
        for(String s : array)
             System.out.println(s);
        System.out.println(array.length);
    }
}
