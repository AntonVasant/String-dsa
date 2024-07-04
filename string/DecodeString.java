package string;

import java.util.Stack;

public class DecodeString {
    public static void decode(String str) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else if (c == '[') {
                counts.push(k);
                resultStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder decodedString = currentString;
                currentString = resultStack.pop();
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    currentString.append(decodedString);
                }
            } else {
                currentString.append(c);
            }
        }

        System.out.println(currentString.toString());
    }
}

