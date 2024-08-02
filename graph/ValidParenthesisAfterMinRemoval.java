package graph;
import java.util.*;
public class ValidParenthesisAfterMinRemoval {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        boolean found = false;

        queue.offer(s);
        set.add(s);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (isValid(current)) {
                    result.add(current);
                    found = true;
                }

                if (!found) {
                    for (int j = 0; j < current.length(); j++) {
                        if (current.charAt(j) != '(' && current.charAt(j) != ')') continue;
                        String str = current.substring(0, j) + current.substring(j + 1);
                        if (!set.contains(str)) {
                            set.add(str);
                            queue.offer(str);
                        }
                    }
                }
            }
            if (found) {
                break;
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}
