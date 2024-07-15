package LLD;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TextEditor {
     static final int width = 40;
     List<StringBuilder> list;
     TextEditor(){
         this.list = new ArrayList<>();
     }

    void helperJustify(String str,int maxWidth){
         String[] array = str.split("\\s+");
         int index = 0;
         while (index < array.length){
             int last = index + 1;
             StringBuilder current = new StringBuilder();
             int totalCount = array[index].length()+1;
             while (last < array.length){
                 if (current.length() + 1 + array[last].length() > maxWidth)break;
                 totalCount += array[last].length();
                 last++;
             }
             current.append(array[index]).append(" ");
             int difference = last - index -1;
             if (difference == 0 || last == array.length){
                 for (int i = index +1; i < last; i++){
                     current.append(array[i]);
                     current.append(" ");
                 }
                 for (int i = current.length(); i < maxWidth; i++)
                     current.append(" ");
             }else {
                 int spaces = (maxWidth - totalCount)/difference-1;
                 int extraSpaces = (maxWidth - totalCount)% difference-1;
                 for (int i = index+1; i < last; i++){
                     current.append(array[i]).append(" ");
                     for (int s = spaces ;s >0; s++){
                         current.append(" ");
                     }
                     if (extraSpaces > 0){
                         current.append(" ");
                         extraSpaces--;
                     }
                 }
             }
             index = last;
             list.add(current);
         }
         printAll();
    }

     void textJustify(int maxWidth){
        StringBuilder sb = new StringBuilder();
        for (StringBuilder s : list){
            sb.append(s).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        helperJustify(sb.toString(),maxWidth);
     }
     void insert(int row,int col,String word){
         if (row < 1 || col > width) return;
         StringBuilder sb = list.get(row-1);
         sb.insert(col,word);
         WrapText();
     }

    void WrapText(){
         List<StringBuilder> newList = new ArrayList<>();
        StringBuilder current = new StringBuilder();
         for (StringBuilder sb : list){
             String[] array = sb.toString().split(" ");
             for (String s : array){
                 if (current.length()+1+s.length()  > width){
                     newList.add(current);
                     current = new StringBuilder();
                 }
                 if (!current.isEmpty())
                     current.append(" ");
                 current.append(s);
             }
         }
         if (!current.isEmpty())
             newList.add(current);
         list = newList;
    }

    void deleteChar(int startRow,int endRow,int startCol,int endCol){
         if (startRow == endRow){
             StringBuilder sb = list.get(startRow-1);
             sb.delete(startCol-1,endCol-1);
         }else {
             StringBuilder start = list.get(startRow-1);
             StringBuilder end = list.get(endRow-1);
             start.delete(startCol-1,start.length());
             end.delete(0,endCol-1);
             for (int i = startRow+1; i < endRow; i++){
                 list.remove(i);
             }
         }
         WrapText();
    }

    void numberOfWords(){
         int count = 0;
         for (StringBuilder sb : list){
             count += sb.toString().split(" ").length;
         }
        System.out.println(count);
    }

    void search(String str){
         for (int i = 0; i < list.size(); i++){
             int index = list.get(i).indexOf(str);
             if (index != -1)
                 System.out.println("found in row "+i+" "+index);
         }
    }

    void findAndReplace(String str,String replacement){
         List<StringBuilder> newList = new ArrayList<>();
         for (StringBuilder s: list){
             String string = s.toString().replace(str,replacement);
             newList.add(new StringBuilder(string));
         }
         list = newList;
         WrapText();
    }

    void deleteLine(int row){
         if (row < 1) {
             System.out.println("invalid row number");
             return;
         }
         else {
             list.remove(row-1);
             WrapText();
         }
    }

    void initialize(String str){
        String[] arr = str.split(" ");
        StringBuilder current = new StringBuilder();
        for (String s : arr){
            if (current.length()+s.length()+1 > width){
                list.add(current);
                current = new StringBuilder();
            }
            if (!current.isEmpty()){
                current.append(" ");
            }
            current.append(s);
        }
        if (!current.isEmpty()) list.add(current);
    }

    void printAll(){
         for (StringBuilder s : list){
             System.out.println(s);
         }
    }
}
