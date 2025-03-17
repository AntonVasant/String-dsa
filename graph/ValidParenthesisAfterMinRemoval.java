package graph;
import java.util.*;
public class ValidParenthesisAfterMinRemoval {
    public static List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        boolean found = false;

        queue.offer(s);
        set.add(s);

        while (!queue.isEmpty()) {
            int size = queue.size();

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

    private static boolean isValid(String s) {
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


    public static String removeBrackets(String s) {
        StringBuilder ans = new StringBuilder();
        int[] v = new int[s.length()];
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> st1 = new HashSet<>();
        HashSet<Integer> st2 = new HashSet<>();
        HashSet<Integer> st3 = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
                v[i] = st.peek();
            } else if (s.charAt(i) == ')') {
                v[i] = st.peek();
                st.pop();
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && !st.isEmpty()) {
                v[i] = st.peek();
                st1.add(st.peek());
            } else if ((s.charAt(i) == '*' || s.charAt(i) == '/') && !st.isEmpty()) {
                v[i] = st.peek();
                st3.add(st.peek());
            } else if (!st.isEmpty()) {
                v[i] = st.peek();
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*' && s.charAt(i) != '/' && s.charAt(i) != '-') continue;
            int j = i + 1;
            if (s.charAt(i) == '-') {
                while (j < s.length() && s.charAt(j) == '(') {
                    if (st1.contains(v[j])) {
                        st2.add(j);
                    }
                    j++;
                }
                continue;
            }
            j = i + 1;
            while (j < s.length() && s.charAt(j) == '(') {
                if (st1.contains(v[j])) {
                    st2.add(j);
                }
                j++;
            }
            if (s.charAt(i) == '/') {
                j = i + 1;
                while (j < s.length() && s.charAt(j) == '(') {
                    if (st3.contains(v[j])) {
                        st2.add(j);
                    }
                    j++;
                }
            }
            j = i - 1;
            while (j >= 0 && s.charAt(j) == ')') {
                if (st1.contains(v[j])) {
                    st2.add(j);
                }
                j--;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ')' && s.charAt(i) != '(') {
                ans.append(s.charAt(i));
            } else {
                if (st2.contains(v[i])) {
                    ans.append(s.charAt(i));
                }
            }
        }

        return ans.toString();
    }

    static boolean recreationalSpot(int[] arr , int n){
        Stack<Integer> stack = new Stack<>();
        int[] leftMin = new int[n];
        leftMin[0] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++)
            leftMin[i] = Math.min(leftMin[i-1], arr[i-1]);
        for (int i = n-1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() < leftMin[i])
                stack.pop();

            if (!stack.isEmpty() && stack.peek() < arr[i])
                return true;

            stack.push(arr[i]);
        }
        return false;
    }


    static String lexicographicallySmallest(String S, int k) {
        k = isPowerOfTwo(S.length()) ? k/2 : k * 2;
        if (k > S.length())
            return "-1";
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()){
            while (!stack.isEmpty() && stack.peek() > c && k > 0){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (!stack.isEmpty() && k > 0){
            stack.pop();
            k--;
        }

        StringBuilder builder = new StringBuilder();
        for (char c : stack)
            builder.append(c);
        return builder.toString();
    }

    private static boolean isPowerOfTwo(int num){
        while (num > 0){
            if (num == 2)
                return true;
            if (num % 2 != 0)
                return false;
            num /= 2;
        }
        return true;
    }


    static int findMaxLen(String S) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int max = 0;
        for (int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if (c == '(') s.push(i);
            else {
                s.pop();
                if (s.isEmpty()) s.push(i);
                else max = Math.max(max, i - s.peek());
            }
        }
        return max;

    }
    public static void main(String[] args) {

    }
}
