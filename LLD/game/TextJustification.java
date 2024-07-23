package LLD.game;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static List<String> textJustify(String[] array, int totalWidth) {
        List<String> list = new ArrayList<>();
        int index = 0;
        while (index < array.length) {
            int last = index + 1;
            int totalCharCount = 0;
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
}
