package LLD.game;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static List<String> textJustify(String[] array, int totalWidth) {
        List<String> list = new ArrayList<>();
        int index = 0;
        while (index < array.length) {
            int last = index + 1;
            int totalCharCount;
            totalCharCount = array[index].length();

            while (last < array.length) {
                if (totalCharCount + 1 + array[last].length() > totalWidth) break;
                totalCharCount += 1 + array[last].length();
                last++;
            }
            StringBuilder currentLine = new StringBuilder();
            currentLine.append(array[index]);
            int difference = last - index - 1;
            if (difference == 0 || last == array.length) {
                for (int i = index + 1; i < last; i++) {
                    currentLine.append(" ").append(array[i]);
                }
                for (int i = currentLine.length(); i <= totalWidth; i++) {
                    currentLine.append(" ");
                }
            } else {
                int spaces = (totalWidth - totalCharCount) / difference;
                int extraSpaces = (totalWidth - totalCharCount) % difference;
                for (int i = index + 1; i < last; i++) {
                    for (int s = spaces; s > 0; s--) {
                        currentLine.append(" ");
                    }
                    if (extraSpaces > 0) {
                        currentLine.append(" ");
                        extraSpaces--;
                    }
                    currentLine.append(array[i]);
                }
            }
            list.add(currentLine.toString());
            index = last;
        }
        return list;
    }

    public static List<String> getTexts(String[] arr, int total){
        int totalLetterCount;
        List<String> ans = new ArrayList<>();
        int index = 0;
        int length = arr.length;
        while (index < length) {
            int last = index + 1;
            totalLetterCount = arr[index].length();
            while (last < length){
                if (totalLetterCount + 1 + arr[last].length() > total) break;
                totalLetterCount += 1 + arr[last].length();
                last++;
            }

            StringBuilder builder = new StringBuilder();
            builder.append(arr[index]);
            int difference = last - index - 1;
            if (difference == 0 || last == length){
                for (int i = index + 1; i < last; i++){
                    builder.append(" ").append(arr[i]);
                }

                while (builder.length() < total)
                    builder.append(" ");
            }
            else {
                int totalSpace = total - totalLetterCount + difference;
                int individualSpace = totalSpace/ difference;
                int leftOverSpace = totalSpace % difference;
                for (int i = index+1; i < last; i++){
                    for (int space = 0; space < individualSpace; space++){
                        builder.append(" ");
                    }
                    builder.append(arr[i]);
                    if (leftOverSpace > 0){
                        builder.append(" ");
                        leftOverSpace--;
                    }
                }
            }
            index = last;
            ans.add(builder.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> list = getTexts(new String[]{"Mershesha", "I", "Met" ,"you", "At", "Rohini", "College", "at", "first",
                "and", "i","fell", "in", "love"}, 8);
        for (String s : list)
            System.out.println(s);
    }
}
